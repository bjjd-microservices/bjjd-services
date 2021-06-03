package com.jmk.account.feign.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jmk.people.model.Devotee;
import com.jmk.people.model.Member;
import com.jmk.people.model.Sevadar;

/**
 * 
 */
@FeignClient(name="people-service") //Service id of people management service
public interface PeopleMgmtServiceClient {

	@PostMapping(value="/api/people-service/devotee/",produces="application/json",consumes="application/json")
	ResponseEntity<Devotee> createDevotee(@Valid @RequestBody Devotee devotee);
	
	@GetMapping(value="/api/people-service/devotee/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Devotee> findDevoteeDetailsById(@PathVariable("id") Long id);
	
	@GetMapping(value="/api/people-service/member/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Member> findMemberDetailsById(@PathVariable("id") Long id) ;
	
	@GetMapping(value="/api/people-service/sevadar/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Sevadar> findSevadarDetailsById(@PathVariable("id") Long id) ;
			
}

