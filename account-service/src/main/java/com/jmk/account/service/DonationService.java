package com.jmk.account.service;

import java.time.LocalDate;
import java.util.List;

import com.jmk.account.model.Donation;

public interface DonationService {

	public Donation saveDonation(Donation donation);
	
	public List<Donation> saveDonations(List<Donation> donations);
	
	public Donation findDonationDetailsById(Long id);
	
	public void deleteDonationById(Long id);
	
	public List<Donation> findDonationDetailsByDateRange(LocalDate startDate,LocalDate endDate);
	
}

