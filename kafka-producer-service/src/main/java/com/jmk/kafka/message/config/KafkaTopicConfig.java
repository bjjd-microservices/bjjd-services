package com.jmk.kafka.message.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic topicMail() {
		return TopicBuilder.name("topic-mail").partitions(5).build();
	}
	
	@Bean
	public NewTopic topicSMS() {
		return TopicBuilder.name("topic-sms").partitions(5).build();
	}
	
	@Bean
	public NewTopic topicWhatsapp() {
		return TopicBuilder.name("topic-whatsapp").partitions(5).build();
	}
	
}
