package com.jmk.messaging.api;

import org.springframework.web.bind.annotation.RestController;

import com.jmk.messaging.model.Message;

@RestController
public class MessageApiController implements MessageApi{

	@Override
	public String sendMessage(Message message) {
		return "ok";
	}

}
