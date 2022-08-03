package com.jmk.account.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.account.model.Donation;
import com.jmk.account.repository.DonationRepository;
import com.jmk.eh.exception.EntityNotFoundException;

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

	@Override
	public Donation findDonationDetailsById(Long id) {
		Optional<com.jmk.account.entity.Donation> optionalDonation=repository.findById(id);
		if(!optionalDonation.isPresent()) {
			throw new EntityNotFoundException(com.jmk.account.entity.Donation.class,"id",id.toString());
		}
		Donation donationModel=mapper.map(optionalDonation.get(),Donation.class);
		return donationModel;
	}

	@Override
	public void deleteDonationById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Donation> findDonationDetailsByDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}
}

