package com.jmk.account.service;

import java.time.LocalDate;
import java.util.List;

import com.jmk.account.model.Donation;
import com.jmk.project.model.Project;

public interface DonationService {

	public Donation saveDonation(Donation donation);
	
	public List<Donation> saveDonations(List<Donation> donations);
	
	public Donation findDonationDetailsById(Long id);

	Donation updateDonation(Long id, Donation donation);
	
	public void deleteDonationById(Long id);
	
	public List<Donation> findDonationDetailsByDateRange(LocalDate startDate,LocalDate endDate);
	
}

