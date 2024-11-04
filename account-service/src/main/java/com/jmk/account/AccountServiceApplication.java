package com.jmk.account;

import com.jmk.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(AppConfig.class)
public class AccountServiceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(AccountServiceApplication.class);

    private final AppConfig appConfig;

    public AccountServiceApplication(AppConfig appConfig){
        this.appConfig=appConfig;
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(AccountServiceApplication.class).run(args);
        
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("MySQL hostname  : {} ", appConfig.getHostname());

    }
    
}

