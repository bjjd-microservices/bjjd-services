package com.jmk.people.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.enums.Status;
import com.jmk.people.feign.client.UserMgmtServiceClient;
import com.jmk.people.model.Devotee;
import com.jmk.people.service.PersonMgmtService;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

@RestController
public class DevoteeApiController implements DevoteeApi {

    private static final Logger log = LoggerFactory.getLogger(DevoteeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
	private UserMgmtServiceClient userMgmtServiceClient;
    
    @Resource(name="devoteeMgmtService")
    private PersonMgmtService<Devotee> personMgmtService;
    
    @org.springframework.beans.factory.annotation.Autowired
    public DevoteeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

	public ResponseEntity<Devotee> createDevotee(
			@ApiParam(value = "", required = true) @Valid @RequestBody Devotee devotee,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			if(StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(devotee,user);
			}
			devotee = personMgmtService.savePerson(devotee);
			return new ResponseEntity<Devotee>(devotee, HttpStatus.OK);
		}

		return new ResponseEntity<Devotee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<List<Devotee>> createDevotees(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Devotee> devotees,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")) {
			if (StringUtils.isNotBlank(username)) {
				final User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				devotees = devotees.stream().map(devotee -> enrichCommonDetails(devotee, user))
						.collect(Collectors.toList());
			}

			devotees = personMgmtService.savePersons(devotees);
			if (devotees != null) {
				return new ResponseEntity<List<Devotee>>(devotees,HttpStatus.OK);
			}
		}

		return new ResponseEntity<List<Devotee>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

    public ResponseEntity<Void> deleteDevoteeById(@ApiParam(value = "Devotee Id",required=true) @PathVariable("id") Long id) {
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	personMgmtService.deletePersonById(id);
        }
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Devotee> findDevoteeByMobileNumber(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "") @Valid @RequestParam(value = "mobileNo", required = false) String mobileNo) {
		String accept = request.getHeader("Accept");
		if (accept != null && (accept.contains("application/json") || accept.contains("*"))) {
			Devotee devotee = personMgmtService.findPersonByMobileNumber(mobileNo);
			return new ResponseEntity<Devotee>(devotee, HttpStatus.OK);
		}
		return new ResponseEntity<Devotee>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

    public ResponseEntity<Devotee> findDevoteeDetailsById(@ApiParam(value = "Devotee Id",required=true) @PathVariable("id") Long id) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Devotee devotee = personMgmtService.findPersonDetailsById(id);
			return new ResponseEntity<Devotee>(devotee, HttpStatus.OK);
		}
        return new ResponseEntity<Devotee>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Devotee>> findDevoteesByStatus(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			List<Devotee> devotees = personMgmtService.findAllPersonsByStatus(Status.A);
			return new ResponseEntity<List<Devotee>>(devotees, HttpStatus.OK);
		}

		return new ResponseEntity<List<Devotee>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Devotee> updateDevoteeById(@ApiParam(value = "Devotee Id",required=true) @PathVariable("id") Long id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Devotee devotee) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if(StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(devotee,user);
			}
			devotee = personMgmtService.savePerson(devotee);
			return new ResponseEntity<Devotee>(devotee, HttpStatus.OK);
		}

		return new ResponseEntity<Devotee>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private Devotee enrichCommonDetails(Devotee devotee,User user) {
		if (devotee.getId() == null) {
			devotee.setCreatedOn(LocalDateTime.now());
			devotee.setCreatedBy(user.getId());
			devotee.setGroupId(user.getGroupId());
		}
		devotee.setWhenModified(LocalDateTime.now());
		devotee.setModifiedBy(user.getId());
		return devotee;
	}

}
