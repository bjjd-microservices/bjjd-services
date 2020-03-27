package com.jmk.people.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.people.model.Member;
import com.jmk.people.test.util.PersonUtility;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberMgmtServiceTest {
	
	@Resource(name="memberMgmtService")
	private PersonMgmtService<Member> personMgmtService;
	
	private Member member;
	
	@Test
	public void savePerson() {
		member=PersonUtility.createMemberModel();
		member=personMgmtService.savePerson(member);
		Assert.assertNotNull(member);
	}

}
