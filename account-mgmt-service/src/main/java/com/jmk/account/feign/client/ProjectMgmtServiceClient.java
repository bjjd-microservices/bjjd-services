package com.jmk.account.feign.client;

import java.util.List;

import com.jmk.account.model.Donation;

public interface ProjectMgmtServiceClient {

	public Donation saveDonation(Donation donation);
	
	public List<Donation> saveDonations(List<Donation> donations);
}
