package com.jmk.user.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.user.api.util.UserModelUtility;
import com.jmk.user.model.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class UserMgmtServiceTest {
	
	private User user;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMgmtService userMgmtService;

	@Before
	public void setUp() {
		user=UserModelUtility.createUserModel();
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
	@Test
	public void testCreateUser() {
		User user1=userMgmtService.saveUser(user);
		Assert.assertNotNull(user1);
		
	}
}
