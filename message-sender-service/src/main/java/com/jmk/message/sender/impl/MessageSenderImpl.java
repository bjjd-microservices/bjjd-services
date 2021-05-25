package com.jmk.message.sender.impl;

import org.springframework.stereotype.Component;

import com.jmk.message.sender.MessageSender;
import com.jmk.messaging.model.Message;

@Component
public class MessageSenderImpl implements MessageSender {

	@Override
	public String sendMessage(Message message) {
		return "Message Sent";
	}

}
