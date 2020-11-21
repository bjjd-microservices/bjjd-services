package com.jmk.user.repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.enums.DocumentType;
import com.jmk.enums.MessageStatus;
import com.jmk.user.entity.Address;
import com.jmk.user.entity.Identity;
import com.jmk.user.entity.Module;
import com.jmk.user.entity.Role;
import com.jmk.user.entity.User;
import com.jmk.user.enums.Group;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	@Before
	public void setUp() {
		user=new User();
		user.setUsername("rajivbansal2981");
		user.setPassword("rajiv");
		user.setDisplayName("Rajiv Bansal");
		user.setEmailSent(MessageStatus.N);
		user.setCreatedOn(LocalDateTime.now());
	//	user.setGroupId(Group.BJJD.name());
		user.setWhenModified(LocalDateTime.now());
		
		Set<Identity> identities=new HashSet<>();
		
		Identity identity=new Identity();
		identity.setDocumentNumber("AOKPB9699G");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.PANCARD);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setUser(user);
		identities.add(identity);
		
		identity=new Identity();
		identity.setDocumentNumber("DL0519990152868");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.DRIVINGLICENSE);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setUser(user);
		identities.add(identity);
		
		identity=new Identity();
		identity.setDocumentNumber("1234567899999");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.AADHARCARD);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setUser(user);
		identities.add(identity);
		user.setIdentities(identities);
		
		Set<Address> addresses=new HashSet<>();
		
		Address mailingAddress=new Address();
		mailingAddress.setHouseNo("503");
		mailingAddress.setAddressLine1("U-503,5th Floor");
		mailingAddress.setAddressLine2("Hyde Park,Sector-78");
		mailingAddress.setCity("Noida");
		mailingAddress.setCountry("INDIA");
		mailingAddress.setCreatedOn(LocalDateTime.now());
	//	mailingAddress.setGroupId(Group.BJJD.name());
		mailingAddress.setWhenModified(LocalDateTime.now());	
		mailingAddress.setPinCode("201301");
		mailingAddress.setLandmark("Navin Bharti Public School");
		mailingAddress.setState("Uttar Pradesh");
		mailingAddress.setUser(user);
		addresses.add(mailingAddress);
		
		Address permanentAddress=new Address();
		permanentAddress.setHouseNo("503");
		permanentAddress.setAddressLine1("U-503,5th Floor");
		permanentAddress.setAddressLine2("Hyde Park,Sector-78");
		permanentAddress.setCity("Noida");
		permanentAddress.setCountry("INDIA");
		permanentAddress.setCreatedOn(LocalDateTime.now());
	//	permanentAddress.setGroupId(Group.BJJD.name());
		permanentAddress.setWhenModified(LocalDateTime.now());	
		permanentAddress.setPinCode("201301");
		permanentAddress.setLandmark("Navin Bharti Public School");
		permanentAddress.setState("Uttar Pradesh");
		permanentAddress.setUser(user);
		addresses.add(permanentAddress);
		
		Set<User> users=new HashSet<>();
		users.add(user);
		
		Role role=new Role();
		role.setId(1003L);
		role.setName("ADMIN");
		role.setCreatedOn(LocalDateTime.now());
		//	user.setGroupId(Group.BJJD.name());
			role.setWhenModified(LocalDateTime.now());
			
		role.setUsers(users);

		Module module=new Module();
		module.setId(1003L);
		module.setName("ADMIN");
		module.setCreatedOn(LocalDateTime.now());
		//	user.setGroupId(Group.BJJD.name());
		module.setWhenModified(LocalDateTime.now());
		role.setModules(Arrays.asList(module));
		
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
	}
	
	@Test
	public void testCreateUser() {
		User user1=userRepository.save(user);
		Assert.assertNotNull(user1);
		
	}
	
}
