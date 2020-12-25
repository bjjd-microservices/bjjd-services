package com.jmk.messaging.util;

import com.jmk.account.model.Donation;
import com.jmk.account.model.Expense;
import com.jmk.darshan.model.Darshan;
import com.jmk.messaging.model.Message;

public class MessageBuilder {
	
	public static Message build(Darshan darshan) {
		Message message=new Message();
		message.setBody("Namaste");
		return message;
	}
	
	public static Message build(Donation donation) {
		Message message=new Message();
		message.setBody("Namaste");
		return message;
	}
	
	public static Message build(Expense expense) {
		Message message=new Message();
		message.setBody("Namaste");
		return message;
	}
	
}
