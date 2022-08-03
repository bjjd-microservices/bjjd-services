package com.jmk.message.sender.feign.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jmk.messaging.model.Message;

@FeignClient(name="kafka-producer-service") //Service id of message sender service
public interface KakfaMessageProducerServiceClient {
	@PostMapping(value="/api/kafka-producer-service/message/send-message/",produces="application/json",consumes="application/json")
	public ResponseEntity<String> sendMessage(@Valid @RequestBody Message message);
	
	@PostMapping(value="/api/kafka-producer-service/message/send-messages/",produces="application/json",consumes="application/json")
	public ResponseEntity<String> sendMessages(@Valid @RequestBody List<Message> messages);
}
