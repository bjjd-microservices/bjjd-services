package com.jmk.account.api;

import java.util.List;

import javax.annotation.Resource;
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
import com.jmk.account.enums.DonorType;
import com.jmk.account.model.Donation;
import com.jmk.account.service.DonationService;
import com.jmk.account.util.DonorCreator;
import com.jmk.account.util.RequestValidator;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")
@RestController
public class DonationApiController implements DonationApi {

	private static final Logger log = LoggerFactory.getLogger(DonationApiController.class);

	private final HttpServletRequest request;
	
	@Autowired
	private DonationService donationService;
	
	@Resource(name="donationRequestValidator")
	private RequestValidator<Donation> validator;
	
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
			if (validator.validate(donation)) {
				if (DonorType.DEVOTEE.equals(donation.getDonorType()) && donation.getDonorId() == null) {
					donorCreator.createDevotee(donation);
				}
				donation = donationService.saveDonation(donation);
			}
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

    public ResponseEntity<Void> deleteDonationById(
			@ApiParam(value = "Donation Id", required = true) @PathVariable("id") Long id) {
    	donationService.deleteDonationById(id);
        //Below return statement is the correct way to handle the delete request
        return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Donation> findDonationDetailsById(
			@ApiParam(value = "Donation Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			Donation donation = donationService.findDonationDetailsById(id);
			return new ResponseEntity<Donation>(donation, HttpStatus.OK);
		}
		return new ResponseEntity<Donation>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Donation> updateDonationById(
			@ApiParam(value = "Donation Id", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Donation donation) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			donation = donationService.saveDonation(donation);
			return new ResponseEntity<Donation>(donation, HttpStatus.OK);
		}

		return new ResponseEntity<Donation>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
