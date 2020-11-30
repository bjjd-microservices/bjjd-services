package com.jmk.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.cache.feign.client.UserMgmtServiceClient;
import com.jmk.user.model.User;

@Component
public class UserCache {

	@Autowired
	private UserMgmtServiceClient userMgmtServiceCacheClient;
	
	@Cacheable(cacheNames="userCache",key="#username",unless="#result == null")
	public User getUserByUsername(String username) {
		ResponseEntity<User> userResponseEntity=userMgmtServiceCacheClient.findUserDetailsByUserName(username);
		User user=userResponseEntity.getBody();
		return user;
	}
}

