package com.jmk.people;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@ComponentScan(basePackages = "com.jmk")
public class PeopleMgmtRestApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PeopleMgmtRestApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.modulesToInstall(new JavaTimeModule());
		return builder.build();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}