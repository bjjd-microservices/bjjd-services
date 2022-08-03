package com.jmk.people.test.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jmk.enums.AddressType;
import com.jmk.enums.DocumentType;
import com.jmk.enums.Group;
import com.jmk.enums.Status;
import com.jmk.people.enums.MemberType;
import com.jmk.people.model.Address;
import com.jmk.people.model.Identity;
import com.jmk.people.model.Member;

public class PersonUtility {
	
	public static Member createMemberModel() {
		Member member=new Member();
		member.username("rajivbansal2981");
		member.setStatus(Status.A);
		member.setFirstName("Rajiv Kumar");
		member.setMobileNo("9999779379");
		member.setLastName("Bansal");
		member.setMemberType(MemberType.LIFETIME);
		member.setCreatedOn(LocalDateTime.now());
		member.setGroupId(Group.BJJD.getGroupId());
		member.setWhenModified(LocalDateTime.now());
		member.setValidity(LocalDate.now());
		member.setMemberType(MemberType.LIFETIME);
		
		Identity identity=new Identity();
		identity.setDocumentNumber("AOKPB9699G");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.PANCARD);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setPerson(member);
	    member.addIdentitiesItem(identity);
		
		identity=new Identity();
		identity.setDocumentNumber("DL0519990152868");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.DRIVINGLICENSE);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setPerson(member);
		member.addIdentitiesItem(identity);
		
		identity=new Identity();
		identity.setDocumentNumber("1234567899999");
		identity.setDocumentName("RajivKumarBansal");
		identity.setDocumentType(DocumentType.AADHARCARD);
		identity.setCreatedOn(LocalDateTime.now());
		identity.setGroupId(Group.BJJD.getGroupId());
		identity.setWhenModified(LocalDateTime.now());
		identity.setPerson(member);
		member.addIdentitiesItem(identity);

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
		mailingAddress.setPerson(member);
		member.addAddressesItem(mailingAddress);
		
		Address permanentAddress=new Address();
		permanentAddress.setHouseNo("502");
		permanentAddress.setAddressLine1("U-502,5th Floor");
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
		permanentAddress.setPerson(member);
		member.addAddressesItem(permanentAddress);
		
		return member;
	}
	
	
}
