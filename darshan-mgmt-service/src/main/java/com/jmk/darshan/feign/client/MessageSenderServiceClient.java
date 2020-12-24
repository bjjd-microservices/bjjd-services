package com.jmk.darshan.feign.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jmk.messaging.model.Message;

/**
 * 
 */
@FeignClient(name="message-sender-service") //Service id of message sender service
public interface MessageSenderServiceClient {

	@PostMapping(value="/api/message-sender-service/message/send-message/",produces="application/json",consumes="application/json")
	public ResponseEntity<String> sendMessage(@Valid @RequestBody Message message);
	
}

