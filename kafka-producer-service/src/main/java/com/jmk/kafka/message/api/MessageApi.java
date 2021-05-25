package com.jmk.kafka.message.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jmk.messaging.model.Message;

@RequestMapping(value="/message")
public interface MessageApi {

	@RequestMapping(value = "/send-message",
	        produces = { "application/json", "application/xml" }, 
	        consumes = { "application/json", "application/xml" },
	        method = RequestMethod.POST)
	public ResponseEntity<String> sendMessage(@RequestBody Message message,@RequestHeader(value="xChannel", required=false) String xChannel);
	
    @RequestMapping(value = "/send-messages",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<String> sendMessages(@RequestBody List<Message> messages,@RequestHeader(value="xChannel", required=false) String xChannel);

}
