package com.jmk.account.service;

import java.util.List;

import com.jmk.account.model.Donation;

public interface DonationService {

	public Donation saveDonation(Donation donation);
	
	public List<Donation> saveDonations(List<Donation> donations);
}
