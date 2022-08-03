package org.jmk.bjjd.member.service;

import org.jmk.bjjd.member.model.MemberModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberMgmtServiceTest {

	@Autowired
	private MemberMgmtService service;
	
	@Test
	public void testCreateMember() {
		MemberModel memberModel=new MemberModel();
		memberModel.setFirstName("RajivKumar");
		memberModel.setLastName("Bansal");
		memberModel.setUserName("rajivbansal2981");
		memberModel.setPassword("rajiv");
		memberModel.setUserType("admin");
		memberModel=service.save(memberModel);
		Assert.assertNotNull(memberModel);
	}
	
}
