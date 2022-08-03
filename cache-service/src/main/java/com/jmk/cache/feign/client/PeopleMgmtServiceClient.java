package com.jmk.cache.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmk.people.model.Devotee;
import com.jmk.people.model.Member;
import com.jmk.people.model.Sevadar;

/**
 * 
 */
@FeignClient(name="people-service",contextId="people-cache-service") //Service id of people management service
public interface PeopleMgmtServiceClient {

	@GetMapping(value="/api/people-service/devotee/findByMobileNumber",produces="application/json",consumes="application/json")
	ResponseEntity<Devotee> findDevoteeByMobileNumber(@RequestParam("mobileNo") String mobileNo);
	
	@GetMapping(value="/api/people-service/member/findByMobileNumber",produces="application/json",consumes="application/json")
	ResponseEntity<Member> findMemberByMobileNumber(@RequestParam("mobileNo") String mobileNo);

	
	@GetMapping(value="/api/people-service/sevadar/findByMobileNumber",produces="application/json",consumes="application/json")
	ResponseEntity<Sevadar> findSevadarByMobileNumber(@RequestParam("mobileNo") String mobileNo) ;
			
}

