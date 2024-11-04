package com.jmk.people.repository;

import com.jmk.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jmk.people.entity.Person;

public interface PersonRepository<T extends Person> extends JpaRepository<T,Long> {
	@Query("SELECT p FROM com.jmk.people.entity.Person p WHERE person_type=?1 and p.mobileNo=?2")
	T findPersonByTypeAndMobileNo(String type,String mobileNo);

	@Query("SELECT p FROM com.jmk.people.entity.Person p WHERE person_type=?1 and p.id=?2")
	T findPersonByTypeAndId(String type,Long id);

	@Query("SELECT p FROM com.jmk.people.entity.Person p WHERE person_type=?1")
	Iterable<T> findAllByType(String type);

	Iterable<T> findByStatus(Status status);

	T findByMobileNo(String mobileNo);
	
}

