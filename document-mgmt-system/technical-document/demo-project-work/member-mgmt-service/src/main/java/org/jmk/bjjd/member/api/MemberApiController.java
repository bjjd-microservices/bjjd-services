package org.jmk.bjjd.member.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jmk.bjjd.member.model.MemberModel;
import org.jmk.bjjd.member.service.MemberMgmtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-06T08:07:29.390+05:30")

@RestController
public class MemberApiController implements MemberApi {

	private static final Logger log = LoggerFactory.getLogger(MemberApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private MemberMgmtService service;

	@org.springframework.beans.factory.annotation.Autowired
	public MemberApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<MemberModel> createMember(
			@ApiParam(value = "", required = true) @Valid @RequestBody MemberModel body,
			@ApiParam(value = "") @RequestHeader(value = "X-Request-ID", required = false) String xRequestID,
			@ApiParam(value = "") @RequestHeader(value = "X-Channel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			MemberModel memberModel = service.save(body);
			return new ResponseEntity<MemberModel>(memberModel, HttpStatus.OK);
		}

		return new ResponseEntity<MemberModel>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> deleteMember(
			@ApiParam(value = "MemberId to be delete", required = true) @PathVariable("memberId") Long memberId,
			@ApiParam(value = "") @RequestHeader(value = "X-Request-ID", required = false) String xRequestID,
			@ApiParam(value = "") @RequestHeader(value = "X-Channel", required = false) String xChannel) {
		service.deleteById(memberId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
