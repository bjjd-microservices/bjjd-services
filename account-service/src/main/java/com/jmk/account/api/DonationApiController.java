package com.jmk.account.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.enums.DonorType;
import com.jmk.account.feign.client.MessageSenderServiceClient;
import com.jmk.account.feign.client.UserMgmtServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.account.service.DonationService;
import com.jmk.account.util.DonorCreator;
import com.jmk.account.util.RequestValidator;
import com.jmk.messaging.util.MessageBuilder;
import com.jmk.people.model.Devotee;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")
@RestController
public class DonationApiController implements DonationApi {

	private final HttpServletRequest request;
	
	@Autowired
	private DonationService donationService;
	@Autowired
	private MessageSenderServiceClient messageSenderService;
	
	@Resource(name="donationRequestValidator")
	private RequestValidator<Donation> validator;
	
	@Autowired
	private UserMgmtServiceClient userMgmtServiceClient;

	
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
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			if (validator.validate(donation)) {
				if (DonorType.DEVOTEE.equals(donation.getDonorType()) && donation.getDonorId() == null) {
					Devotee devotee=donorCreator.createDevotee(donation);
					donation.setDonorId(devotee.getId());
				}
				if(StringUtils.isNotBlank(username)) {
					User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
					enrichCommonDetails(donation,user);
				}
				donation = donationService.saveDonation(donation);
				messageSenderService.sendMessage(MessageBuilder.build(donation));
			}
			return new ResponseEntity<Donation>(donation, HttpStatus.OK);
		}
		return new ResponseEntity<Donation>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public ResponseEntity<List<Donation>> saveDonations(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Donation> donations,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
    	String accept = request.getHeader("Accept");
    	String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			for(Donation donation:donations) {
				if (DonorType.DEVOTEE.equals(donation.getDonorType()) && donation.getDonorId() == null) {
					Devotee devotee=donorCreator.createDevotee(donation);
					donation.setDonorId(devotee.getId());
				}
			}
			if (StringUtils.isNotBlank(username)) {
				final User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				donations = donations.stream().map(donation -> enrichCommonDetails(donation, user))
						.collect(Collectors.toList());
			}
			donations = donationService.saveDonations(donations);
			messageSenderService.sendMessages(donations.stream().map(donation->MessageBuilder.build(donation)).collect(Collectors.toList()));
			return new ResponseEntity<List<Donation>>(donations,HttpStatus.OK);
		}
        return new ResponseEntity<List<Donation>>(HttpStatus.INTERNAL_SERVER_ERROR);
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
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			if(StringUtils.isNotBlank(username)) {
				User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(donation,user);
			}
			donation = donationService.saveDonation(donation);
			return new ResponseEntity<Donation>(donation, HttpStatus.OK);
		}
		return new ResponseEntity<Donation>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Donation enrichCommonDetails(Donation donation,User user) {
		if (donation.getId() == null) {
			donation.setCreatedOn(LocalDateTime.now());
			donation.setCreatedBy(user.getId());
			donation.setGroupId(user.getGroupId());
		}
		donation.setWhenModified(LocalDateTime.now());
		donation.setModifiedBy(user.getId());
		return donation;
	}
}
