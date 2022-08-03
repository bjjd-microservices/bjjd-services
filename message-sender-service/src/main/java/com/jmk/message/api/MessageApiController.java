package com.jmk.message.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.message.sender.MessageSender;
import com.jmk.messaging.model.Message;

@RestController
public class MessageApiController implements MessageApi{
	
//	@Autowired
//	private KakfaMessageProducerServiceClient kafkaKakfaMessageProducerServiceClient;
	
	@Autowired
	private MessageSender messageSender;

	@Override
	public ResponseEntity<String> sendMessage(@RequestBody Message message,@RequestHeader(value="xChannel", required=false) String xChannel) {
//		kafkaKakfaMessageProducerServiceClient.sendMessage(message);
		messageSender.sendMessage(message);
		return new ResponseEntity<String>("Message has been sent",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> sendMessages(@RequestBody List<Message> messages,@RequestHeader(value="xChannel", required=false) String xChannel) {
	//	kafkaKakfaMessageProducerServiceClient.sendMessages(messages);
		return new ResponseEntity<String>("Message has been sent",HttpStatus.OK);
	}
	

}
