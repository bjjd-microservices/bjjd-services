package com.jmk.account.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.account.feign.client.PeopleMgmtServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.people.model.Devotee;

@Component
public class DonorCreator {

	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceClient;
	
	public Devotee createDevotee(Donation donation) {
		Devotee devotee=new Devotee();
		devotee.setUserName("Rajiv Bansal");
		devotee.setFirstName(donation.getDonorName());
		devotee.setDevoteeType("Regular");
		ResponseEntity<Devotee> responseEntity= peopleMgmtServiceClient.createDevotee(devotee);
		return responseEntity.getBody();
	}
	
}


 