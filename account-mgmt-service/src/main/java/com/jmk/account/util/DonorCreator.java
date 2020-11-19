package com.jmk.account.util;

import java.time.LocalDateTime;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.account.feign.client.PeopleMgmtServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.enums.DocumentType;
import com.jmk.enums.Group;
import com.jmk.enums.Status;
import com.jmk.people.model.Address;
import com.jmk.people.model.Devotee;
import com.jmk.people.model.Identity;

@Component
public class DonorCreator {

	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceClient;

	public Devotee createDevotee(Donation donation) {
		Devotee devotee = new Devotee();
		devotee.setUserName("Rajiv Bansal");
		devotee.setFirstName(donation.getDonorName());
		devotee.setMobileNo(donation.getDonorMobileNo());
		devotee.setDevoteeType("Regular");
		devotee.setStatus(Status.A);
		devotee.setCreatedOn(LocalDateTime.now());
		devotee.setGroupId(Group.BJJD.getGroupId());
		devotee.setWhenModified(LocalDateTime.now());

		if (StringUtils.isNotBlank(donation.getDonorPANNo())) {
			Identity panIdentity = new Identity();
			panIdentity.setDocumentNumber(donation.getDonorPANNo());
			panIdentity.setDocumentName(donation.getDonorName());
			panIdentity.setDocumentType(DocumentType.PANCARD);
			panIdentity.setCreatedOn(LocalDateTime.now());
			panIdentity.setGroupId(Group.BJJD.getGroupId());
			panIdentity.setWhenModified(LocalDateTime.now());
			panIdentity.setPerson(devotee);
			devotee.addIdentitiesItem(panIdentity);
		}

		if (StringUtils.isNotBlank(donation.getDonorAadharNo())) {
			Identity aadharIdentity = new Identity();
			aadharIdentity.setDocumentNumber(donation.getDonorAadharNo());
			aadharIdentity.setDocumentName(donation.getDonorName());
			aadharIdentity.setDocumentType(DocumentType.AADHARCARD);
			aadharIdentity.setCreatedOn(LocalDateTime.now());
			aadharIdentity.setGroupId(Group.BJJD.getGroupId());
			aadharIdentity.setWhenModified(LocalDateTime.now());
			aadharIdentity.setPerson(devotee);
			devotee.addIdentitiesItem(aadharIdentity);
		}
		Address permanentAddress = new Address();
		permanentAddress.setAddressLine1(donation.getDonorAddress());
		permanentAddress.setCity(donation.getDonorCity());
		permanentAddress.setCountry("INDIA");
		permanentAddress.setCreatedOn(LocalDateTime.now());
		permanentAddress.setGroupId(Group.BJJD.getGroupId());
		permanentAddress.setWhenModified(LocalDateTime.now());
		permanentAddress.setState(donation.getDonorState());
		permanentAddress.setPerson(devotee);
		devotee.addAddressesItem(permanentAddress);

		ResponseEntity<Devotee> responseEntity = peopleMgmtServiceClient.createDevotee(devotee);
		return responseEntity.getBody();
	}

}
