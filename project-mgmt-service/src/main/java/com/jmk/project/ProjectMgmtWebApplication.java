package com.jmk.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableJpaRepositories
@EnableCircuitBreaker
@ComponentScan(basePackages = { "io.swagger", "com.jmk.project" })
public class ProjectMgmtWebApplication {

	public static void main(String[] args) throws Exception {
   	 SpringApplication.run(ProjectMgmtWebApplication.class,args);
   }

	  @Bean
	    public ModelMapper modelMapper() {
	    	return new ModelMapper();
	    }
	    
	
}
