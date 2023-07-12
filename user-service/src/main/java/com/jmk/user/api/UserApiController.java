package com.jmk.user.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jmk.user.feign.client.S3ServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.user.model.User;
import com.jmk.user.service.UserService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-27T08:54:51.282+05:30")

@RestController
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;
    
    @Autowired(required = false)
    private S3ServiceClient s3ServiceClient;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public String appUpAndRunning() {
        return "{healthy:true}";
    }

	public ResponseEntity<User> createUser(@ApiParam(value = "", required = true) @Valid @RequestPart User user,
			@RequestPart("photo") MultipartFile photo,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		enrichCommonUserDetails(user);
		user = userService.saveUser(user);
		if (photo != null) {
            s3ServiceClient.uploadFile("USERS",user.getId().toString(),"Photo",photo);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}



    public ResponseEntity<Void> createUsersWithArrayInput(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<User> users,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	users=users.stream().map(user->enrichCommonUserDetails(user)).collect(Collectors.toList());
        	users=userService.saveUsers(users);
        	 if(users!=null) {
        		 return new ResponseEntity<>(HttpStatus.OK);
        	 }
        }
       
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Integer> deleteUserByUsername(@ApiParam(value = "username") @Valid @RequestParam(value = "username", required = true) String username) {
    	Integer deleteRecords=userService.deleteUserByUsername(username);
        return new ResponseEntity<Integer>(deleteRecords,HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUserById(@ApiParam(value = "User Id",required=true) @PathVariable("id") Long id) {
         userService.deleteUserById(id);
         //Below return statement is the correct way to handle the delete request
         return ResponseEntity.noContent().build();
    }

    public ResponseEntity<User> findUserDetailsById(@ApiParam(value = "User Id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
            	User user=userService.findUserDetailsById(id);
                return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
	public ResponseEntity<User> findUserDetailsByUserName(
			@ApiParam(value = "xChannel") @RequestHeader(value = "xChannel", required = false) String xChannel,
			@ApiParam(value = "username") @Valid @RequestParam(value = "username", required = false) String username) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			User user = userService.findUserDetailsByUserName(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<User> loginUser(@NotNull @Size(min=3,max=36) @ApiParam(value = "username to be find", required = true) @Valid @RequestParam(value = "username", required = true) String username,@NotNull @Size(min=3,max=36) @ApiParam(value = "password of the user", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			User user = userService.findUserDetailsByUserName(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Void> logoutUser() {
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<User> updateUserById(@ApiParam(value = "User Id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        	enrichCommonUserDetails(user);
        	user=userService.saveUser(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }

        return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<User> updateUserByUserName(@ApiParam(value = "Username",required=true) @PathVariable("username") String username,@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
        		enrichCommonUserDetails(user);
            	user=userService.saveUser(user);
            	return new ResponseEntity<User>(user,HttpStatus.OK);
        }

        return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * Enrich Common User Details
     * @param user
     * @return user the user
     */
    private User enrichCommonUserDetails(User user) {
		if (user.getId() == null) {
			user.setCreatedOn(LocalDateTime.now());
		}
		user.setWhenModified(LocalDateTime.now());
		return user;
	}
}
