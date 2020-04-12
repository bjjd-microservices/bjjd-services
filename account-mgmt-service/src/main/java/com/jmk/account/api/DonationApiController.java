package com.jmk.account.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.enums.DonorType;
import com.jmk.account.feign.client.PeopleMgmtServiceClient;
import com.jmk.account.feign.client.UserMgmtServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.account.service.DonationService;
import com.jmk.account.util.DonorCreator;
import com.jmk.people.model.Devotee;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")
@RestController
public class DonationApiController implements DonationApi {

	private static final Logger log = LoggerFactory.getLogger(DonationApiController.class);

	private final HttpServletRequest request;
	
	@Autowired
	private DonationService donationService;
	
	@Autowired
	private DonorCreator donorCreator;
	
	@org.springframework.beans.factory.annotation.Autowired
	public DonationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<Donation> saveDonation(
			@ApiParam(value = "", required = true) @Valid @RequestBody Donation donation,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if(DonorType.DEVOTEE.equals(donation.getDonorType()) || donation.getDonorId()==null) {
				donorCreator.createDevotee(donation);
			}
			donation = donationService.saveDonation(donation);
			return new ResponseEntity<Donation>(donation, HttpStatus.OK);
		}

		return new ResponseEntity<Donation>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
    public ResponseEntity<Void> saveDonations(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Donation> donations,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			donations = donationService.saveDonations(donations);
			return new ResponseEntity<>(HttpStatus.OK);
		}
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
