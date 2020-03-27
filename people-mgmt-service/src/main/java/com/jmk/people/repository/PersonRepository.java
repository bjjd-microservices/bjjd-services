package com.jmk.people.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmk.people.entity.Person;

public interface PersonRepository<T extends Person> extends CrudRepository<T,Long>{

}
