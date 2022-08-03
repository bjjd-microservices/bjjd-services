package org.jmk.bjjd.member.api;

import org.jmk.bjjd.member.model.MemberModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberApiControllerTest {

	private MockMvc mockMvc;
	private MemberModel memberModel;
	private ObjectMapper objectMapper = new ObjectMapper();

	// @Autowired
	// private WebApplicationContext context;

	@Autowired
	private MemberApi controller;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
		// mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		memberModel = new MemberModel();
		memberModel.setFirstName("RKumar");
		memberModel.setLastName("Bansal");
		memberModel.setUserName("rajivbansal2981");
		memberModel.setPassword("rajiv");
		memberModel.setUserType("admin");
	}

	@Test
	public void testCreateMember() {

		String jsonRequest = null;
		try {
			jsonRequest = objectMapper.writeValueAsString(memberModel);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/member").accept(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonRequest))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
