package com.jmk.account.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.account.model.Donation;
import com.jmk.account.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService{
	
	@Autowired
	private DonationRepository repository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Donation saveDonation(Donation donationModel) {
		com.jmk.account.entity.Donation donationEntity=mapper.map(donationModel, com.jmk.account.entity.Donation.class);
		donationEntity=repository.save(donationEntity);
		donationModel=mapper.map(donationEntity,Donation.class);
		return donationModel;
	}

}
