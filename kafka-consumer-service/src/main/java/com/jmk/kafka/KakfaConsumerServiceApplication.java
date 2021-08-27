package com.jmk.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

import com.jmk.kafka.ribbon.config.RibbonConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableDiscoveryClient
@EnableSwagger2
@AutoConfigureAfter(RibbonAutoConfiguration.class)
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@EnableFeignClients(basePackages = "com.jmk")
@ComponentScan(basePackages = { "com.jmk" })
@EnableKafka
@SpringBootApplication
public class KakfaConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakfaConsumerServiceApplication.class, args);
	}

}
