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

import io.swagger.annotations.ApiParam;

/**
 * 
 */
@FeignClient(name="people-mgmt-service") //Service id of people management service
public interface PeopleMgmtServiceClient {

	@PostMapping(value="/api/people-mgmt-service/devotee/",produces="application/json",consumes="application/json")
	ResponseEntity<Devotee> createDevotee(@Valid @RequestBody Devotee devotee);
	
	@GetMapping(value="/api/people-mgmt-service/devotee/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Devotee> findDevoteeDetailsById(@PathVariable("id") Long id);
	
	@GetMapping(value="/api/people-mgmt-service/member/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Member> findMemberDetailsById(@PathVariable("id") Long id) ;
	
	@GetMapping(value="/api/people-mgmt-service/sevadar/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Sevadar> findSevadarDetailsById(@PathVariable("id") Long id) ;
			
}
