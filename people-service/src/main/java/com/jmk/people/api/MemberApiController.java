package com.jmk.people.api;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.jmk.people.model.Devotee;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	public String checkHealth() {
		return "{healthy:true}";
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

	@Override
	public ResponseEntity<List<Member>> findAllMembers() {
		List<Member> members = personMgmtService.findAllPersonsByStatus(Status.A);
		if (members != null) {
			return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
		}
		return new ResponseEntity<List<Member>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Member> findMemberById(Long id) {
			Member member = personMgmtService.findPersonById(id);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	public ResponseEntity<Member> findMemberByMobileNumber(String mobileNo) {
			Member member = personMgmtService.findPersonByMobileNumber(mobileNo);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	public ResponseEntity<List<Member>> findMembersByStatus(String status) {
			List<Member> members = personMgmtService.findAllPersonsByStatus(Status.valueOf(status));
			return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	public ResponseEntity<Member> updateMember(Long id,Member member) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				User user = userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(member, user);
			}
			member = personMgmtService.updatePerson(id,member);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(member.getId())
					.toUri();

			return ResponseEntity.created(location)
					.build();
		}

		return new ResponseEntity<Member>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Void> deleteMemberById(Long id) {
		personMgmtService.deletePersonById(id);
		return ResponseEntity.noContent().build();
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
