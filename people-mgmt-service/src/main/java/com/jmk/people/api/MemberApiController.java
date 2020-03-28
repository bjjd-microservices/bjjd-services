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
import com.jmk.people.model.Member;
import com.jmk.people.service.PersonMgmtService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

@RestController
public class MemberApiController implements MemberApi {

    private static final Logger log = LoggerFactory.getLogger(MemberApiController.class);

    private final HttpServletRequest request;
    
    @Resource(name="memberMgmtService")
    private PersonMgmtService<Member> personMgmtService;

    @org.springframework.beans.factory.annotation.Autowired
    public MemberApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Member> createMember(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Member member,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
    	 String accept = request.getHeader("Accept");
         if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
             	 member=personMgmtService.savePerson(member);
                 return new ResponseEntity<Member>(member,HttpStatus.OK);
         }
         return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Void> createMembersWithArrayInput(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Member> members,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	members=personMgmtService.savePersons(members);
        	if(members!=null) {
        		return new ResponseEntity<>(HttpStatus.OK);
        	}
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteMemberById(@ApiParam(value = "Member Id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	personMgmtService.deletePersonById(id);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Member> findMemberByMobileNumber(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "") @Valid @RequestParam(value = "mobileNo", required = false) String mobileNo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
            	Member member=personMgmtService.findPersonByMobileNumber(mobileNo);
                return new ResponseEntity<Member>(member, HttpStatus.OK);
        }
        return new ResponseEntity<Member>(HttpStatus.NOT_IMPLEMENTED);
    }

	public ResponseEntity<Member> findMemberDetailsById(
			@ApiParam(value = "Member Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Member member = personMgmtService.findPersonDetailsById(id);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
		}
		return new ResponseEntity<Member>(HttpStatus.NOT_IMPLEMENTED);
	}

    public ResponseEntity<List<Member>> findMembersByStatus(@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel,@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			List<Member> members = personMgmtService.findAllPersonsByStatus(Status.A);
			return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
		}

		return new ResponseEntity<List<Member>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Member> updateMemberById(@ApiParam(value = "Member Id",required=true) @PathVariable("id") Long id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Member member) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
            	member=personMgmtService.savePerson(member);
                return new ResponseEntity<Member>(member,HttpStatus.OK);
        }

        return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
