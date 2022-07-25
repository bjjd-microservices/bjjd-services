package com.jmk.user.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.user.api.util.UserModelUtility;
import com.jmk.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	
	private User user;
	
	@Autowired
	private UserService userMgmtService;

	@Before
	public void setUp() {
		user=UserModelUtility.createUserModel();
	}
	
	@Test
	public void testCreateUser() {
		user=userMgmtService.saveUser(user);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testFindUserDetailsByUsername() {
			user=userMgmtService.findUserDetailsByUserName(user.getUsername());
			Assert.assertNotNull(user);
	}
	
	@Test
	public void testRemoveUserDetailsByUsername() {
		int deleteRecords=userMgmtService.deleteUserByUsername(user.getUsername());
		Assert.assertEquals(deleteRecords,1);
	}
}
