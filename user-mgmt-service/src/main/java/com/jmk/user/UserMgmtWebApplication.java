package com.jmk.user;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
@EnableCircuitBreaker
@ComponentScan(basePackages = { "io.swagger", "com.jmk.user" })
public class UserMgmtWebApplication {

    public static void main(String[] args) throws Exception {
    	 SpringApplication.run(UserMgmtWebApplication.class,args);
    }

    @Bean
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    }
    
}
