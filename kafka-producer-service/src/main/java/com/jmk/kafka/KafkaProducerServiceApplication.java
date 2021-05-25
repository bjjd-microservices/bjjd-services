package com.jmk.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("com.jmk")
@EnableEurekaClient
@EnableKafka
@EnableAsync
@SpringBootApplication
public class KafkaProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerServiceApplication.class, args);
	}

}
