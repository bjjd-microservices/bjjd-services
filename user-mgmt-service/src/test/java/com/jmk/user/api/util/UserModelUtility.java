package com.jmk.user.api.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.jmk.enums.AddressType;
import com.jmk.enums.DocumentType;
import com.jmk.enums.MessageSent;
import com.jmk.enums.Status;
import com.jmk.user.enums.Group;
import com.jmk.user.model.Address;
import com.jmk.user.model.Identity;
import com.jmk.user.model.Module;
import com.jmk.user.model.Profile;
import com.jmk.user.model.Role;
import com.jmk.user.model.User;

public class UserModelUtility {
	
	public static User createUserModel() {
		User user=new User();
		user.username("rajivbansal2981").password("Rajiv@379").displayName("Rajiv Bansal");
		user.setEmailSent(MessageSent.N);
		user.setSmsSent(MessageSent.N);
		user.setStatus(Status.A);
		user.setCreatedOn(LocalDateTime.now());
		user.setGroupId(Group.BJJD.getGroupId());
		user.setWhenModified(LocalDateTime.now());
		
		Identity identity=new Identity();
		identity.setDocumentNumber("AOKPB9699G");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.PANCARD);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setUser(user);
		user.addIdentitiesItem(identity);
		
		identity=new Identity();
		identity.setDocumentNumber("DL0519990152868");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.DRIVINGLICENSE);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setUser(user);
		user.addIdentitiesItem(identity);
		
		identity=new Identity();
		identity.setDocumentNumber("1234567899999");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.AADHARCARD);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setUser(user);
		user.addIdentitiesItem(identity);
		
		
		Profile profile=new Profile();
		profile.setFirstName("Rajiv");
		profile.setCreatedOn(LocalDateTime.now());
		profile.setGroupId(Group.BJJD.getGroupId());
		profile.setWhenModified(LocalDateTime.now());
		profile.setUser(user);
		user.setProfile(profile);
		
		Set<Address> addresses=new HashSet<>();
		
		Address mailingAddress=new Address();
		mailingAddress.setHouseNo("503");
		mailingAddress.setAddressLine1("U-503,5th Floor");
		mailingAddress.setAddressLine2("Hyde Park,Sector-78");
		mailingAddress.setAddressType(AddressType.PERMANENT);
		mailingAddress.setCity("Noida");
		mailingAddress.setCountry("INDIA");
		mailingAddress.setCreatedOn(LocalDateTime.now());
		mailingAddress.setGroupId(Group.BJJD.getGroupId());
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
		permanentAddress.setAddressType(AddressType.MAILING);
		permanentAddress.setCity("Noida");
		permanentAddress.setCountry("INDIA");
		permanentAddress.setCreatedOn(LocalDateTime.now());
		permanentAddress.setGroupId(Group.BJJD.getGroupId());
		permanentAddress.setWhenModified(LocalDateTime.now());	
		permanentAddress.setPinCode("201301");
		permanentAddress.setLandmark("Navin Bharti Public School");
		permanentAddress.setState("Uttar Pradesh");
		permanentAddress.setUser(user);
		addresses.add(permanentAddress);
		
		user.setAddresses(addresses);
		
		
		Set<User> users=new HashSet<>();
		users.add(user);
		Role role=new Role();
		role.setId(1003L);
		role.setName("ADMIN");
		role.setCreatedOn(LocalDateTime.now());
		role.setGroupId(Group.BJJD.getGroupId());
		role.setStatus(Status.A);
		role.setWhenModified(LocalDateTime.now());
		
		role.setUsers(users);

		Module module=new Module();
		module.setId(1003L);
		module.setName("ADMIN");
		module.setCreatedOn(LocalDateTime.now());
		module.setGroupId(Group.BJJD.getGroupId());
		module.setStatus(Status.A);
		module.setWhenModified(LocalDateTime.now());
		role.setModules(Arrays.asList(module));
		role.setUsers(users);
		user.addRolesItem(role);
		return user;
	}
	
	
}
