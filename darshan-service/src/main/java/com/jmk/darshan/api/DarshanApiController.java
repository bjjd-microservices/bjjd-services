package com.jmk.darshan.api;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.darshan.enums.VisitorType;
import com.jmk.darshan.feign.client.MessageSenderServiceClient;
import com.jmk.darshan.feign.client.UserMgmtServiceClient;
import com.jmk.darshan.model.Darshan;
import com.jmk.darshan.service.DarshanService;
import com.jmk.darshan.util.VisitorCreator;
import com.jmk.darshan.validator.RequestValidator;
import com.jmk.messaging.util.MessageBuilder;
import com.jmk.people.model.Devotee;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-12T00:51:00.325+05:30")

@RestController
public class DarshanApiController implements DarshanApi {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DarshanApiController.class);
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	
	@Autowired
	private MessageSenderServiceClient messageSenderService;
	
	@Autowired
	private UserMgmtServiceClient userMgmtServiceClient;
	
	@Autowired
	private RequestValidator requestValidator;
	
	@Autowired
	private VisitorCreator visitorCreator;
	
	@Autowired
	private DarshanService darshanService;

	public String checkHealth() {
		return "{healthy:true}";
	}

	public DarshanApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	
	public ResponseEntity<Darshan> saveDarshan(Darshan darshan,String xChannel) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (requestValidator.validate(darshan)) {
				if (VisitorType.DEVOTEE.equals(darshan.getVisitorType()) && darshan.getVisitorId() == null) {
					Devotee devotee = visitorCreator.createDevotee(darshan);
					darshan.setVisitorId(devotee.getId());
				}
				if(StringUtils.isNotBlank(username)) {
					User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
					enrichCommonDetails(darshan,user);
				}
				darshan = darshanService.saveDarshan(darshan);
				messageSenderService.sendMessage(MessageBuilder.build(darshan));
			}
			return new ResponseEntity<Darshan>(darshan, HttpStatus.OK);
		}
		return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<List<Darshan>> saveDarshans(List<Darshan> darshans, String xChannel) {
		String accept = request.getHeader("Accept");
		String username = request.getHeader("username");

		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				final User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				darshans = darshans.stream().map(darshan -> enrichCommonDetails(darshan, user))
						.collect(Collectors.toList());
			}
			darshans = darshanService.saveDarshans(darshans);
			if (darshans != null) {
				messageSenderService.sendMessages(darshans.stream().map(darshan->MessageBuilder.build(darshan)).collect(Collectors.toList()));
				return new ResponseEntity<List<Darshan>>(darshans, HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<Darshan>>(HttpStatus.NOT_IMPLEMENTED);
	}


	public ResponseEntity<Darshan> findDarshanDetailsById(Long id) {
			Darshan darshan = darshanService.findDarshanDetailsById(id);
			return new ResponseEntity<Darshan>(darshan, HttpStatus.OK);
	}

	public ResponseEntity<Darshan> updateDarshan(Long id,Darshan darshan) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if(StringUtils.isNotBlank(username)) {
				User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(darshan,user);
			}

			darshan = darshanService.updateDarshan(id,darshan);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(darshan.getId())
					.toUri();

			return ResponseEntity.created(location).build();
		}
		return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> deleteDarshanById(Long id) {
			darshanService.deleteDarshanById(id);
			return ResponseEntity.noContent().build();
	}

	private Darshan enrichCommonDetails(Darshan darshan,User user) {
		if (darshan.getId() == null) {
			darshan.setCreatedOn(LocalDateTime.now());
			darshan.setCreatedBy(user.getId());
			darshan.setGroupId(user.getGroupId());
		}
		darshan.setWhenModified(LocalDateTime.now());
		darshan.setModifiedBy(user.getId());
		return darshan;
	}

}
