package com.jmk.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.jmk")
@SpringBootApplication
@ComponentScan(basePackages = "com.jmk")
@EnableKafka
public class KakfaConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakfaConsumerServiceApplication.class, args);
	}

}
