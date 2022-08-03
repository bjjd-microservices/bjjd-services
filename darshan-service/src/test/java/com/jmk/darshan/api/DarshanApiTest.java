package com.jmk.darshan.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.model.Donation;
import com.jmk.darshan.enums.VisitorType;
import com.jmk.darshan.model.Darshan;
import com.jmk.enums.Group;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DarshanApiTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Darshan darshan;
	
	@Before
	public void setUp() {
		darshan=new Darshan();
		darshan.setVisitorName("Rajiv Bansal");
		darshan.setVisitingDate(LocalDate.now());
		darshan.setVisitorCity("Delhi");
		darshan.setVisitorState("Delhi");
		darshan.setVisitorType(VisitorType.DEVOTEE);
		darshan.setVisitorMobileNo("9999779379");
		darshan.setTotalKids(1);
		darshan.setTotalMen(1);
		darshan.setTotalWomen(1);
		darshan.setTotalVisitors(3);
		darshan.setCreatedOn(LocalDateTime.now());
		darshan.setGroupId(Group.BJJD.getGroupId());
		darshan.setWhenModified(LocalDateTime.now());
	}
	
	@Test
	public void saveDarshan() {
		
		String jsonDarshan=null;
		try {
			jsonDarshan=objectMapper.writeValueAsString(darshan);
			System.out.print(jsonDarshan);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:4379/darshan/")
					.accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(jsonDarshan)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			darshan=objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), Darshan.class);
			Assert.assertNotNull(darshan);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

