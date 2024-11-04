package com.jmk.user.service;

import java.util.List;

import com.jmk.project.model.Project;
import com.jmk.user.model.User;

/**
 * @author rkbansal
 *
 */
public interface UserService {
	
	User saveUser(User user);

	List<User> saveUsers(List<User> users);

	List<User> findAllUsers();
	
	User findUserDetailsByUserName(String userName);
	
	User findUserDetailsById(Long id);

	User updateUser(Long id, User user);

	void deleteUserById(Long id);
	
	int deleteUserByUsername(String username);
	

}
