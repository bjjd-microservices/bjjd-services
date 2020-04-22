package com.jmk.account.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jmk.account.feign.client.ProjectMgmtServiceClient;
import com.jmk.account.model.Donation;

@Component("donationRequestValidator")
public class ExpenseRequestValidator implements RequestValidator<Donation> {
	
	@Autowired
	private ProjectMgmtServiceClient projectMgmtServiceClient;

	public boolean validate(Donation donation) {
		 return validProject(donation.getProjectId());
	}

	@Override
	public ProjectMgmtServiceClient getProjectMgmtServiceClient() {
		return projectMgmtServiceClient;
	}
	
}
