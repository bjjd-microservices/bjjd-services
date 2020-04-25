package com.jmk.people.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.people.model.Member;
import com.jmk.people.test.util.PersonUtility;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberMgmtServiceTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Resource(name="memberMgmtService")
	private PersonMgmtService<Member> personMgmtService;
	
	private Member member;
	
	@Test
	public void testSavePerson() {
		String jsonRequest=null;
		try {
			jsonRequest = objectMapper.writeValueAsString(PersonUtility.createMemberModel());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonRequest);
		member=PersonUtility.createMemberModel();
		member=personMgmtService.savePerson(member);
		Assert.assertNotNull(member);
	}
	
	@Test
	public void testFindPersonByMobileNumber() {
		member=personMgmtService.findPersonByMobileNumber("9999779379");
		Assert.assertNotNull(member);
	}
	
	@Test
	public void testFindPersonByID() {
		member=personMgmtService.findPersonDetailsById(1L);
		Assert.assertNotNull(member);
	}

}
