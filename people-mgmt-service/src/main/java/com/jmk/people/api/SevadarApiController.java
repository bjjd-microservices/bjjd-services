package com.jmk.people.api;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.enums.Status;
import com.jmk.people.model.Sevadar;
import com.jmk.people.service.PersonMgmtService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

@RestController
public class SevadarApiController implements SevadarApi {

    private static final Logger log = LoggerFactory.getLogger(SevadarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Resource(name="sevadarMgmtService")
    private PersonMgmtService<Sevadar> personMgmtService;

    @org.springframework.beans.factory.annotation.Autowired
    public SevadarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Sevadar> createSevadar(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Sevadar sevadar,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
   	 String accept = request.getHeader("Accept");
     if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
    	 	 sevadar=personMgmtService.savePerson(sevadar);
             return new ResponseEntity<Sevadar>(sevadar,HttpStatus.OK);
     }
     return new ResponseEntity<Sevadar>(HttpStatus.INTERNAL_SERVER_ERROR);
}

    public ResponseEntity<Void> createSevadarsWithArrayInput(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Sevadar> sevadars,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	sevadars=personMgmtService.savePersons(sevadars);
        	if(sevadars!=null) {
        		return new ResponseEntity<>(HttpStatus.OK);
        	}
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteSevadarById(@ApiParam(value = "Sevadar Id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	personMgmtService.deletePersonById(id);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Sevadar> findSevadarByMobileNumber(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "") @Valid @RequestParam(value = "mobileNo", required = false) String mobileNo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
            	Sevadar sevadar=personMgmtService.findPersonByMobileNumber(mobileNo);
                return new ResponseEntity<Sevadar>(sevadar, HttpStatus.OK);
        }
        return new ResponseEntity<Sevadar>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Sevadar> findSevadarDetailsById(@ApiParam(value = "Sevadar Id",required=true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Sevadar sevadar = personMgmtService.findPersonDetailsById(id);
			return new ResponseEntity<Sevadar>(sevadar, HttpStatus.OK);
		}
		return new ResponseEntity<Sevadar>(HttpStatus.NOT_IMPLEMENTED);
	}

    public ResponseEntity<List<Sevadar>> findSevadarsByStatus(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			List<Sevadar> sevadars = personMgmtService.findAllPersonsByStatus(Status.A);
			return new ResponseEntity<List<Sevadar>>(sevadars, HttpStatus.OK);
		}

		return new ResponseEntity<List<Sevadar>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Sevadar> updateSevadarById(@ApiParam(value = "Sevadar Id",required=true) @PathVariable("id") Long id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Sevadar sevadar) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
            	sevadar=personMgmtService.savePerson(sevadar);
                return new ResponseEntity<Sevadar>(sevadar,HttpStatus.OK);
        }

        return new ResponseEntity<Sevadar>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
