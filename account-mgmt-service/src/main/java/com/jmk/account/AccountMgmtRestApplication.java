package com.jmk.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableJpaRepositories
@EnableFeignClients
@ComponentScan(basePackages = { "com.jmk" })
public class AccountMgmtRestApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplication(AccountMgmtRestApplication.class).run(args);
    }
    
}
