package com.jmk.people.service;

import java.util.List;

import com.jmk.enums.Status;
import com.jmk.people.model.Person;

public interface PersonMgmtService<T extends Person> {
	
	T savePerson(T person);
	
	T findPersonDetailsById(Long id);
	
	void deletePersonById(Long id);
	
	List<T> savePersons(List<T> persons);

	List<T> findAllPersonsByStatus(Status status);
}
