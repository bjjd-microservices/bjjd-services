package com.jmk.kafka.message.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.kafka.message.sender.KafkaMessageSender;
import com.jmk.messaging.model.Message;

@RestController
public class MessageApiController implements MessageApi{
	
	@Autowired
	private KafkaMessageSender kafkaSender;

	@Override
	public ResponseEntity<String> sendMessage(@RequestBody Message message,@RequestHeader(value="xChannel", required=false) String xChannel) {
		kafkaSender.sendMessage("topic-sms",message);
		return new ResponseEntity<String>("Message has been sent",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> sendMessages(@RequestBody List<Message> messages,@RequestHeader(value="xChannel", required=false) String xChannel) {
		return new ResponseEntity<String>("Message has been sent",HttpStatus.OK);
	}
	

}
