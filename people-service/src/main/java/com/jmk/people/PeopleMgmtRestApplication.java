package com.jmk.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
@EnableFeignClients(basePackages = "com.jmk")
@EnableEurekaClient
@ComponentScan(basePackages = "com.jmk")
public class PeopleMgmtRestApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PeopleMgmtRestApplication.class, args);
	}

}

