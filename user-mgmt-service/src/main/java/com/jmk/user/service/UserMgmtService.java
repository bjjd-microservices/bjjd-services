package com.jmk.user.service;

import java.util.List;

import com.jmk.model.user.User;

public interface UserMgmtService {
	
	User saveUser(User user);
	
	void deleteUserById(Long id);
	
	User findUserDetailsByUserName(String userName);
	
	User findUserDetailsById(Long id);
	
	int deleteUserByUsername(String username);
	
	List<User> saveUsers(List<User> users);

	List<User> findAllUsers();
	
}
