package com.jmk.people.service;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.jmk.enums.Status;
import com.jmk.people.model.Address;
import com.jmk.people.model.Identity;
import com.jmk.people.model.Person;

public interface PersonMgmtService<T extends Person> {
	
	T savePerson(T person);
	
	T findPersonDetailsById(Long id);
	
	void deletePersonById(Long id);
	
	List<T> savePersons(List<T> persons);

	List<T> findAllPersonsByStatus(Status status);
	
	T findPersonByMobileNumber(String mobileNumber);
	
	public default <U extends com.jmk.people.entity.Person> U mapModelToEntity(ModelMapper mapper,Person personModel,Class<U> clazz) {
		U personEntity=mapper.map(personModel,clazz);
		for(com.jmk.people.entity.Address address:personEntity.getAddresses()) {
			address.setPerson(personEntity);
		}
		for(com.jmk.people.entity.Identity identity:personEntity.getIdentities()) {
			identity.setPerson(personEntity);
		}
		return personEntity;
	}
	
	public default <U extends Person> U mapEntityToModel(ModelMapper mapper,com.jmk.people.entity.Person personEntity,Class<U> clazz) {
		U personModel=mapper.map(personEntity,clazz);
		for(Address address:personModel.getAddresses()) {
			address.setPerson(personModel);
		}
		for(Identity identity:personModel.getIdentities()) {
			identity.setPerson(personModel);
		}
		return personModel;
	}
	

}
