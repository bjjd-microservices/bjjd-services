package com.jmk.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients(basePackages = "com.jmk")
@EnableJpaRepositories
@ComponentScan(basePackages = { "com.jmk" })
public class PeopleServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PeopleServiceApplication.class, args);
	}

}

