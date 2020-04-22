package com.jmk.account.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.account.enums.DonorType;
import com.jmk.account.feign.client.PeopleMgmtServiceClient;
import com.jmk.account.feign.client.ProjectMgmtServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.people.model.Person;

@Component("donationRequestValidator")
public class DonationRequestValidator implements RequestValidator<Donation> {
	
	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceClient;
	
	@Autowired
	private ProjectMgmtServiceClient projectMgmtServiceClient;

	public boolean validate(Donation donation) {
		 return validDonor(donation) && validProject(donation.getProjectId());
	}
	
	protected boolean validDonor(Donation donation) {
		boolean isValid = false;

		if (donation.getDonorId() != null && donation.getDonorType() != null) {
			ResponseEntity<? extends Person> responseEntity = null;
			switch (donation.getDonorType()) {
			case DEVOTEE:
				responseEntity = peopleMgmtServiceClient.findDevoteeDetailsById(donation.getDonorId());
				break;
			case SEVADAR:
				responseEntity = peopleMgmtServiceClient.findSevadarDetailsById(donation.getDonorId());
				break;
			case MEMBER:
				responseEntity = peopleMgmtServiceClient.findMemberDetailsById(donation.getDonorId());
				break;
			default:
			}
			Person person = responseEntity.getBody();
			isValid = person != null;
		}else if(donation.getDonorId()==null && donation.getDonorType()==DonorType.DEVOTEE) {
			isValid=true;
		}
		return isValid;
	}

	@Override
	public ProjectMgmtServiceClient getProjectMgmtServiceClient() {
		return projectMgmtServiceClient;
	}
	
}
