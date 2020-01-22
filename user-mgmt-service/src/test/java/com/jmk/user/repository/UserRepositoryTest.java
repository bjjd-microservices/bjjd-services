package com.jmk.user.repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmk.enums.MessageSent;
import com.jmk.user.entity.Address;
import com.jmk.user.entity.Identity;
import com.jmk.user.entity.Module;
import com.jmk.user.entity.Role;
import com.jmk.user.entity.User;

import junit.framework.Assert;

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
		user.setEmailSent(MessageSent.N);
		user.setCreatedOn(Timestamp.from(Instant.now()));
	//	user.setGroupId(Group.BJJD.name());
		user.setWhenModified(Timestamp.from(Instant.now()));
		
		Identity identity=new Identity();
		identity.setAadharId("1234567899999");
		identity.setCreatedOn(Timestamp.from(Instant.now()));
	//	identity.setGroupId(Group.BJJD.name());
		identity.setDriverLicenseId("DL0519990152868");
		identity.setPanId("AOKPB9699G");
		identity.setPassportId("S12323423");
		identity.setVoterId("D123123123");
		identity.setWhenModified(Timestamp.from(Instant.now()));
		identity.setUser(user);
		user.setIdentity(identity);
		
		Address mailingAddress=new Address();
		mailingAddress.setHouseNo("503");
		mailingAddress.setAddressLine1("U-503,5th Floor");
		mailingAddress.setAddressLine2("Hyde Park,Sector-78");
		mailingAddress.setAddressType("PERMANENT");
		mailingAddress.setCity("Noida");
		mailingAddress.setCountry("INDIA");
		mailingAddress.setCreatedOn(Timestamp.from(Instant.now()));
	//	mailingAddress.setGroupId(Group.BJJD.name());
		mailingAddress.setWhenModified(Timestamp.from(Instant.now()));	
		mailingAddress.setPinCode("201301");
		mailingAddress.setLandmark("Navin Bharti Public School");
		mailingAddress.setState("Uttar Pradesh");
		mailingAddress.setUser(user);
		user.setMailingAddress(mailingAddress);
		
		Address permanentAddress=new Address();
		permanentAddress.setHouseNo("503");
		permanentAddress.setAddressLine1("U-503,5th Floor");
		permanentAddress.setAddressLine2("Hyde Park,Sector-78");
		permanentAddress.setAddressType("PERMANENT");
		permanentAddress.setCity("Noida");
		permanentAddress.setCountry("INDIA");
		permanentAddress.setCreatedOn(Timestamp.from(Instant.now()));
	//	permanentAddress.setGroupId(Group.BJJD.name());
		permanentAddress.setWhenModified(Timestamp.from(Instant.now()));	
		permanentAddress.setPinCode("201301");
		permanentAddress.setLandmark("Navin Bharti Public School");
		permanentAddress.setState("Uttar Pradesh");
		permanentAddress.setUser(user);
		user.setPermanentAddress(permanentAddress);
		
		Set<User> users=new HashSet<>();
		users.add(user);
		
		Role role=new Role();
		role.setId(1003L);
		role.setName("ADMIN");
		role.setCreatedOn(Timestamp.from(Instant.now()));
		//	user.setGroupId(Group.BJJD.name());
			role.setWhenModified(Timestamp.from(Instant.now()));
			
		role.setUsers(users);

		Module module=new Module();
		module.setId(1003L);
		module.setName("ADMIN");
		module.setCreatedOn(Timestamp.from(Instant.now()));
		//	user.setGroupId(Group.BJJD.name());
		module.setWhenModified(Timestamp.from(Instant.now()));
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
