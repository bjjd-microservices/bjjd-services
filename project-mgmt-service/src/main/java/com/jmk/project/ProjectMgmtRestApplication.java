package com.jmk.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableJpaRepositories
@ComponentScan(basePackages = { "com.jmk" })
public class ProjectMgmtRestApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjectMgmtRestApplication.class, args);
	}

}


