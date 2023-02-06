package com.jmk.user.feign.client;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.jmk.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * To send HTTP Request to a destination user-service Microservice we will need to
 * create a Feign Client interface. Please note the use of @FeignClient
 * annotation which accepts the name user-service under which the destination
 * Microservice is registered with Eureka Discovery Service.
 * 
 * @author rkbansal
 *
 */
@FeignClient(name="aws-service")
public interface S3ServiceClient {
	
	@PostMapping(value = "/uploadfile", produces = { "application/json", "application/xml" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<PutObjectResult> uploadFile(@RequestParam(value = "category", required = true) String category, @RequestParam(value = "id", required = true) String id, @RequestParam(value = "filename", required = true) String filename, @RequestPart("photo") MultipartFile photo);


}


