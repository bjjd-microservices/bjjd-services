package com.jmk.auth.feign.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.model.user.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMgmtServiceClientTest {
	
	@Autowired
	private UserMgmtServiceClient userMgmtServiceClient;
	
	
	@Test
	public void testFindUserDetailsByUsername() {
		ResponseEntity<User> resposneEntity=userMgmtServiceClient.findUserDetailsByUserName("rajivbansal2981");
		Assert.assertNotNull(resposneEntity.getBody());
	}

}
