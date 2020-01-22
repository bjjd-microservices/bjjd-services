package com.jmk.user.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.model.user.User;
import com.jmk.user.api.util.UserModelUtility;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApiTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Value("server.port")
	private String serverPort;

	private User user;

	@Before
	public void setUp() {
		user = UserModelUtility.createUserModel();
	}

	@Test
	public void testCreateUser() {
		String jsonRequest = null;
		System.out.println("Application Server Port: " + serverPort);
		try {
			jsonRequest = objectMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			MvcResult mvcResult=mockMvc.perform(
					MockMvcRequestBuilders.post("http://localhost:3379/user").accept(MediaType.APPLICATION_JSON_VALUE)
							.contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			user=objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), User.class);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserDetailsByUsername() {
		try {
			ResultActions resultActions=mockMvc.perform( MockMvcRequestBuilders
				      .get("http://localhost:3379/user/findByUsername").param("username",user.getUsername())
				      .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE))
				          .andExpect(MockMvcResultMatchers.status().isOk());
			user=objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsByteArray(),User.class);
			Assert.notNull(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
