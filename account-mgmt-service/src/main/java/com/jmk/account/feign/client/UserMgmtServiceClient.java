package com.jmk.account.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmk.user.model.User;

/**
 * To send HTTP Request to a destination user-mgmt-service Microservice we will need to
 * create a Feign Client interface. Please note the use of @FeignClient
 * annotation which accepts the name user-mgmt-service under which the destination
 * Microservice is registered with Eureka Discovery Service.
 * 
 * @author rkbansal
 *
 */
@FeignClient(name="user-mgmt-service") //Service id of User-Mgmt-Service application
public interface UserMgmtServiceClient{
	
	@GetMapping(value="/api/user-mgmt-service/user/findByUsername",produces = "application/json",consumes = "application/json")
	ResponseEntity<User> findUserDetailsByUserName(@RequestParam(value = "username", required = false) String username);

}
