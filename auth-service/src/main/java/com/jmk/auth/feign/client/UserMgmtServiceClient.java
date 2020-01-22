package com.jmk.auth.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jmk.model.user.User;

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
	
    @RequestMapping(value = "/user/{username}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<User> findUserDetailsByUserName(@PathVariable("username") String username);

}
