package com.jmk.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableEurekaClient
@EnableFeignClients(basePackages = "com.jmk")
@SpringBootApplication
@EnableKafka
@EnableAsync
@ComponentScan(basePackages = "com.jmk")
public class MessageSenderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageSenderServiceApplication.class, args);
	}

}

