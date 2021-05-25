package com.jmk.message.sender;

import com.jmk.messaging.model.Message;

public interface MessageSender {
	public String sendMessage(Message message);
}
