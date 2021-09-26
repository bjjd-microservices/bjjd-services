package com.jmk.darshan.util;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.darshan.feign.client.PeopleMgmtServiceClient;
import com.jmk.darshan.model.Darshan;
import com.jmk.enums.Group;
import com.jmk.enums.Status;
import com.jmk.people.model.Address;
import com.jmk.people.model.Devotee;

@Component
public class VisitorCreator {

	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceClient;

	public Devotee createDevotee(Darshan darshan) {
		Devotee devotee = new Devotee();
		devotee.setUserName("Rajiv Bansal");
		devotee.setFirstName(darshan.getVisitorName());
		devotee.setMobileNo(darshan.getVisitorMobileNo());
		devotee.setDevoteeType("Regular");
		devotee.setStatus(Status.A);
		devotee.setCreatedOn(LocalDateTime.now());
		devotee.setGroupId(Group.BJJD.getGroupId());
		devotee.setWhenModified(LocalDateTime.now());

		Address permanentAddress = new Address();
		permanentAddress.setAddressLine1(darshan.getVisitorAddressLine());
		permanentAddress.setCity(darshan.getVisitorCity());
		permanentAddress.setCountry("INDIA");
		permanentAddress.setCreatedOn(LocalDateTime.now());
		permanentAddress.setGroupId(Group.BJJD.getGroupId());
		permanentAddress.setWhenModified(LocalDateTime.now());
		permanentAddress.setState(darshan.getVisitorState());
		permanentAddress.setPerson(devotee);
		devotee.addAddressesItem(permanentAddress);

		ResponseEntity<Devotee> responseEntity = peopleMgmtServiceClient.createDevotee(devotee);
		return responseEntity.getBody();
	}

}


