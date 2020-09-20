package com.jmk.darshan.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.jmk.darshan.model.Darshan;
import com.jmk.darshan.service.DarshanMgmtService;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-12T00:51:00.325+05:30")

@RestController
public class DarshanApiController implements DarshanApi {

	private static final Logger log = LoggerFactory.getLogger(DarshanApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private DarshanMgmtService darshanMgmtService;

	@org.springframework.beans.factory.annotation.Autowired
	public DarshanApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> deleteDarshanById(
			@ApiParam(value = "Darshan Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			darshanMgmtService.deleteDarshanById(id);
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Darshan> findDarshanDetailsById(
			@ApiParam(value = "Darshan Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			Darshan darshan = darshanMgmtService.findDarshanDetailsById(id);
			return new ResponseEntity<Darshan>(darshan, HttpStatus.OK);
		}
		return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Darshan> saveDarshan(
			@ApiParam(value = "", required = true) @Valid @RequestBody Darshan darshan,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			darshan = darshanMgmtService.saveDarshan(darshan);
			return new ResponseEntity<Darshan>(darshan, HttpStatus.OK);
		}
		return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Darshan>> saveDarshans(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Darshan> darshans,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			darshans = darshanMgmtService.saveDarshans(darshans);
			if (darshans != null) {
				return new ResponseEntity<List<Darshan>>(darshans, HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<Darshan>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Darshan> updateDarshanById(
			@ApiParam(value = "Darshan Id", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Darshan darshan) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			darshan = darshanMgmtService.saveDarshan(darshan);
			return new ResponseEntity<Darshan>(darshan, HttpStatus.OK);
		}
		return new ResponseEntity<Darshan>(HttpStatus.NOT_IMPLEMENTED);
	}

}
