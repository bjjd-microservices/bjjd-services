package com.jmk.cache.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmk.user.model.User;

/**
 * To send HTTP Request to a destination user-service Microservice we will need to
 * create a Feign Client interface. Please note the use of @FeignClient
 * annotation which accepts the name user-service under which the destination
 * Microservice is registered with Eureka Discovery Service.
 * 
 * @author rkbansal
 *
 */
@FeignClient(name="user-service",contextId="user-cache-service")
public interface UserMgmtServiceClient{
	
	@GetMapping(value="/api/user-service/user/findByUsername",produces = "application/json",consumes = "application/json")
	ResponseEntity<User> findUserDetailsByUserName(@RequestParam(value = "username", required = false) String username);

}

