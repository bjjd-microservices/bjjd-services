package com.jmk.project.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.project.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectApiTest {
	
	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Value("server.port")
	private String serverPort;
	
	private List<Project> projects;


	@Test
	public void testFindUserDetailsByUsername() {
		try {
			ResultActions resultActions=mockMvc.perform( MockMvcRequestBuilders
				      .get("http://localhost:5379/findByStatus").param("status","A")
				      .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE))
				          .andExpect(MockMvcResultMatchers.status().isOk());
			projects=(List<Project>)objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsByteArray(), List.class);
			Assert.assertNotNull(projects);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
