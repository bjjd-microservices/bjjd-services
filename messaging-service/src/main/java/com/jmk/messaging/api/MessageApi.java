package com.jmk.messaging.api;

import org.springframework.web.bind.annotation.RequestMapping;

import com.jmk.messaging.model.Message;

@RequestMapping(value="/messaging")
public interface MessageApi {

	public String sendMessage(Message message);
}
