package com.jmk.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.cache.feign.client.PeopleMgmtServiceClient;
import com.jmk.people.model.Devotee;
import com.jmk.people.model.Member;
import com.jmk.people.model.Sevadar;

@Component
public class PeopleCache {
	
	@Autowired
	private PeopleMgmtServiceClient peopleMgmtServiceCacheClient;
	
	@Cacheable(cacheNames="memberCache",key="#mobileNo",unless="#result == null")
	public Member getMemberByMobile(String mobileNo) {
		ResponseEntity<Member> responseEntity=peopleMgmtServiceCacheClient.findMemberByMobileNumber(mobileNo);
		Member member=responseEntity.getBody();
		return member;
	}

	@Cacheable(cacheNames="devoteeCache",key="#mobileNo",unless="#result == null")
	public Devotee getDevoteeByMobile(String mobileNo) {
		ResponseEntity<Devotee> responseEntity=peopleMgmtServiceCacheClient.findDevoteeByMobileNumber(mobileNo);
		Devotee devotee=responseEntity.getBody();
		return devotee;
	}
	
	@Cacheable(cacheNames="sevadarCache",key="#mobileNo",unless="#result == null")
	public Sevadar getSevadarByMobile(String mobileNo) {
		ResponseEntity<Sevadar> responseEntity=peopleMgmtServiceCacheClient.findSevadarByMobileNumber(mobileNo);
		Sevadar sevadar=responseEntity.getBody();
		return sevadar;
	}
}


