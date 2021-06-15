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
import com.jmk.people.model.Member;
import com.jmk.people.service.PersonMgmtService;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-27T07:02:52.969Z")

@RestController
public class MemberApiController implements MemberApi {

	private static final Logger log = LoggerFactory.getLogger(MemberApiController.class);

	private final HttpServletRequest request;

	@Autowired
	private UserMgmtServiceClient userMgmtServiceClient;

	@Resource(name = "memberMgmtService")
	private PersonMgmtService<Member> personMgmtService;

	@org.springframework.beans.factory.annotation.Autowired
	public MemberApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<Member> createMember(@ApiParam(value = "", required = true) @Valid @RequestBody Member member,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(member, user);
			}
			member = personMgmtService.savePerson(member);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
		}
		return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<List<Member>> createMembers(@ApiParam(value = "", required = true) @Valid @RequestBody List<Member> members,@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				final User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				members = members.stream().map(member -> enrichCommonDetails(member, user))
						.collect(Collectors.toList());
			}
			members = personMgmtService.savePersons(members);
			if (members != null) {
				return new ResponseEntity<List<Member>>(members,HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<Member>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> deleteMemberById(
			@ApiParam(value = "Member Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			personMgmtService.deletePersonById(id);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Member> findMemberByMobileNumber(
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel,
			@ApiParam(value = "") @Valid @RequestParam(value = "mobileNo", required = false) String mobileNo) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Member member = personMgmtService.findPersonByMobileNumber(mobileNo);
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

	public ResponseEntity<List<Member>> findMembersByStatus(
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel,
			@ApiParam(value = "The status to restrict the results to.  If not provided, all records are returned", allowableValues = "A, I") @Valid @RequestParam(value = "status", required = false) String status) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			List<Member> members = personMgmtService.findAllPersonsByStatus(Status.A);
			return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
		}

		return new ResponseEntity<List<Member>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Member> updateMemberById(
			@ApiParam(value = "Member Id", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Member member) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(member, user);
			}
			member = personMgmtService.savePerson(member);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
		}

		return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Member enrichCommonDetails(Member member, User user) {
		if (member.getId() == null) {
			member.setCreatedOn(LocalDateTime.now());
			member.setCreatedBy(user.getId());
			member.setGroupId(user.getGroupId());
		}
		member.setWhenModified(LocalDateTime.now());
		member.setModifiedBy(user.getId());
		return member;
	}

}
