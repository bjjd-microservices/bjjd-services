package com.jmk.account.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

	/* (non-Javadoc)
	 * @see com.jmk.account.service.DonationService#saveDonations(java.util.List)
	 */
	@Override
	public List<Donation> saveDonations(List<Donation> donationModels) {
		List<com.jmk.account.entity.Donation> donationEntities=donationModels.stream().map(donationModel->mapper.map(donationModel,com.jmk.account.entity.Donation.class)).collect(Collectors.toList());
		Iterable<com.jmk.account.entity.Donation> iterableDonations=repository.saveAll(donationEntities);
		donationModels=StreamSupport.stream(iterableDonations.spliterator(),false).map(donationEntity->mapper.map(donationEntity,Donation.class)).collect(Collectors.toList());
		return donationModels;
	}

	
}
