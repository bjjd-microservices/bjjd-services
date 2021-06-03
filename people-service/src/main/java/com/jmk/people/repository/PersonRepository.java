package com.jmk.people.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jmk.people.entity.Person;

public interface PersonRepository<T extends Person> extends CrudRepository<T,Long>{
	@Query("SELECT p FROM com.jmk.people.entity.Person p WHERE person_type=?1 and p.mobileNo=?2")
	T findPersonByTypeAndMobileNo(String type,String mobileNo);
	
}
