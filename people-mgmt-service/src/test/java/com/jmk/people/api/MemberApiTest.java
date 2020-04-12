package com.jmk.people.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.people.model.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberApiTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testFindMemberDetailsById() {
		try {
			ResultActions resultActions=mockMvc.perform( MockMvcRequestBuilders
				      .get("http://localhost:6379/member/{id}",1L).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE))
				          .andExpect(MockMvcResultMatchers.status().isOk());
			Member member=objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsByteArray(),Member.class);
			Assert.assertNotNull(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
