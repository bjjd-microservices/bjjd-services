package com.jmk.account.feign.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jmk.people.model.Devotee;

/**
 * 
 */
@FeignClient(name="people-mgmt-service") //Service id of people management service
public interface PeopleMgmtServiceClient {

	@GetMapping(value="/api/people-mgmt-service/devotee/",produces="application/json",consumes="application/json")
	ResponseEntity<Devotee> createDevotee(@Valid @RequestBody Devotee devotee);
}
