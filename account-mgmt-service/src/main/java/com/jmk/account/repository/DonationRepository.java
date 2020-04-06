package com.jmk.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmk.account.entity.Donation;


public interface DonationRepository extends CrudRepository<Donation, Long>{

}
