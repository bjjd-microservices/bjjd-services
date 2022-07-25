package com.jmk.user.api;

import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.user.api.util.UserModelUtility;
import com.jmk.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserApiTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static final String BASE_URL="http://localhost:3379";
	

	@Autowired
	private ObjectMapper objectMapper;

	@Value("server.port")
	private String serverPort;

	private User user;

	@Before
	public void setUp() {
		user = UserModelUtility.createUserModel();
	}

	@Test
	public void testCreateUserWithPhoto() {
		String jsonRequest = null;
		System.out.println("Application Server Port: " + serverPort);

		try {
			FileInputStream fis = new FileInputStream("D:\\images\\src\\abcd.jpg");
			MockMultipartFile file1 = new MockMultipartFile("photo", "abc.jpg", "image/jpeg", fis);
			jsonRequest = objectMapper.writeValueAsString(user);
			System.out.println(jsonRequest);

			MockMultipartFile file2 = new MockMultipartFile("user", "", "application/json", jsonRequest.getBytes());

			MvcResult mvcResult = mockMvc
					.perform(MockMvcRequestBuilders.multipart(BASE_URL+"/user/").file(file1).file(file2))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

			user = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), User.class);
			Assert.assertNotNull(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserDetailsByUsername() {
		try {
			ResultActions resultActions=mockMvc.perform( MockMvcRequestBuilders
				      .get(BASE_URL+"/user/findByUsername").param("username",user.getUsername())
				      .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE))
				          .andExpect(MockMvcResultMatchers.status().isOk());
			user=objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsByteArray(),User.class);
			Assert.assertNotNull(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRemoveUserDetailsByUsername() {
		try {
			ResultActions resultActions=mockMvc.perform( MockMvcRequestBuilders
				      .delete(BASE_URL+"/user/deleteByUsername").param("username",user.getUsername())
				      .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE))
				          .andExpect(MockMvcResultMatchers.status().isOk());
			Integer deleteRecords=objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsByteArray(),Integer.class);
			Assert.assertEquals(1, deleteRecords.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
