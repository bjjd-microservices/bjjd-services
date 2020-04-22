package com.jmk.upload;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jmk.upload.config.properties.FileStorageProperties;

@EnableConfigurationProperties({FileStorageProperties.class})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class DataUploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataUploadServiceApplication.class, args);
	}
	
}
