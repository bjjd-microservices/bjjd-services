package com.jmk.darshan.feign.client;

import com.jmk.common.config.LoadBalancerConfiguration;
import com.jmk.messaging.model.Message;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 
 */
@FeignClient(name="message-sender-service",primary = true) //Service id of message sender service
@LoadBalancerClient(name="message-sender-service",configuration = LoadBalancerConfiguration.class)
public interface MessageSenderServiceClient {

	@PostMapping(value="/api/message-sender-service/message/send-message/",produces="application/json",consumes="application/json")
	public ResponseEntity<String> sendMessage(@Valid @RequestBody Message message);
	
	@PostMapping(value="/api/message-sender-service/message/send-messages/",produces="application/json",consumes="application/json")
	public ResponseEntity<String> sendMessages(@Valid @RequestBody List<Message> messages);
	
}

