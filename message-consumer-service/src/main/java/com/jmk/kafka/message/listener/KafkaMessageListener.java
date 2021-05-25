package com.jmk.message.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.jmk.messaging.model.Message;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

@Component
public class KafkaMessageListener {

	private static final String ACCOUNT_SID = "AC42cf569e378c4642a1d4c1a7c441fa44";
	private static final String AUTH_TOKEN = "d64acd48e96a0e88cd175e282ec2d09f";

	@KafkaListener(topics = "topic-sms", groupId = "group-id")
	public void listenSMS(Message smsMessage) {
		if (smsMessage.getBody() != null && smsMessage.getToMobileNo() != null) {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
					.creator(new PhoneNumber("+919999779379"), new PhoneNumber("+13182498391"), "Namaste").create();
			System.out.println("SMS: " + message);
		}
	}

	@KafkaListener(topics = "topic-mail", groupId = "group-id")
	public void listenMail(Message message) {
		System.out.println("Mail: " + message);
	}

	@KafkaListener(topics = "topic-whatsapp", groupId = "group-id")
	public void listenWhatsapp(Message whatsappMessage) {
		if (whatsappMessage.getBody() != null && whatsappMessage.getToMobileNo() != null) {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
					.creator(new PhoneNumber("whatsapp:+919968614549"), new PhoneNumber("whatsapp:+13182498391"),
							whatsappMessage.getBody())
					.create();
		}

	}

}
