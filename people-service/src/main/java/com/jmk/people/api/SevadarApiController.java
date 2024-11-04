package com.jmk.people.api;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.jmk.people.model.Member;
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
import com.jmk.people.model.Sevadar;
import com.jmk.people.service.PersonMgmtService;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

@RestController
public class SevadarApiController implements SevadarApi {
    private static final Logger log = LoggerFactory.getLogger(SevadarApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    
    @Autowired
	private UserMgmtServiceClient userMgmtServiceClient;
    
    @Resource(name="sevadarMgmtService")
    private PersonMgmtService<Sevadar> personMgmtService;

    @org.springframework.beans.factory.annotation.Autowired
    public SevadarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

	public String checkHealth() {
		return "{healthy:true}";
	}

    public ResponseEntity<Sevadar> createSevadar(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Sevadar sevadar,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
   	 String accept = request.getHeader("Accept");
   	String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(sevadar, user);
			}
			sevadar = personMgmtService.savePerson(sevadar);
			return new ResponseEntity<Sevadar>(sevadar, HttpStatus.OK);
		}
     return new ResponseEntity<Sevadar>(HttpStatus.INTERNAL_SERVER_ERROR);
}

	public ResponseEntity<List<Sevadar>> createSevadars(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Sevadar> sevadars,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				
				final User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				sevadars = sevadars.stream().map(sevadar -> enrichCommonDetails(sevadar, user))
						.collect(Collectors.toList());
			}

			sevadars = personMgmtService.savePersons(sevadars);
			if (sevadars != null) {
				return new ResponseEntity<List<Sevadar>>(sevadars,HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<Sevadar>>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<Sevadar>> findAllSevadars() {
		List<Sevadar> sevadars = personMgmtService.findAllPersonsByStatus(Status.A);
		if (sevadars != null) {
			return new ResponseEntity<List<Sevadar>>(sevadars, HttpStatus.OK);
		}
		return new ResponseEntity<List<Sevadar>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Sevadar> findSevadarById(Long id) {
			Sevadar sevadar = personMgmtService.findPersonById(id);
			return new ResponseEntity<Sevadar>(sevadar, HttpStatus.OK);
	}


	public ResponseEntity<Sevadar> findSevadarByMobileNumber(String mobileNo) {
            	Sevadar sevadar=personMgmtService.findPersonByMobileNumber(mobileNo);
                return new ResponseEntity<Sevadar>(sevadar, HttpStatus.OK);
    }


    public ResponseEntity<List<Sevadar>> findSevadarsByStatus(String status) {
			List<Sevadar> sevadars = personMgmtService.findAllPersonsByStatus(Status.valueOf(status));
			return new ResponseEntity<List<Sevadar>>(sevadars, HttpStatus.OK);
    }

    public ResponseEntity<Sevadar> updateSevadar(Long id,Sevadar sevadar) {
        String accept = request.getHeader("Accept");
        String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(sevadar, user);
			}
			sevadar = personMgmtService.updatePerson(id,sevadar);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(sevadar.getId())
					.toUri();

			return ResponseEntity.created(location)
					.build();
		}

        return new ResponseEntity<Sevadar>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

	public ResponseEntity<Void> deleteSevadarById(Long id) {
		personMgmtService.deletePersonById(id);
		return ResponseEntity.noContent().build();
	}
    
    private Sevadar enrichCommonDetails(Sevadar sevadar,User user) {
  		if (sevadar.getId() == null) {
  			sevadar.setCreatedOn(LocalDateTime.now());
  			sevadar.setCreatedBy(user.getId());
  			sevadar.setGroupId(user.getGroupId());
  		}
  		sevadar.setWhenModified(LocalDateTime.now());
  		sevadar.setModifiedBy(user.getId());
  		return sevadar;
  	}


}
