package com.jmk.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.jmk.upload.config.properties.FileStorageProperties;

@EnableConfigurationProperties({FileStorageProperties.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.jmk")
@SpringBootApplication
@ComponentScan(basePackages = "com.jmk")
public class DataUploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataUploadServiceApplication.class, args);
	}
	
}


