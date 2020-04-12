package com.jmk.account.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.account.feign.client.PeopleMgmtServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.people.model.Member;

@Component
public class RequestValidator {
	
	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceClient;

	public boolean validate(Donation donation) {
		boolean isValid=false;
		ResponseEntity<Member> responseEntity=peopleMgmtServiceClient.findMemberDetailsById(1L);
		Member member=responseEntity.getBody();
		return member!=null;
	}
	
}
