package com.jmk.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmk.user.entity.User;


public interface UserRepository extends CrudRepository<User,Long>{

	public User findByUsername(String username);
	
	//A derived delete query must start with deleteBy, followed by the name of the selection criteria
	int deleteByUsername(String username);
}

