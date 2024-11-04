package com.jmk.user;

import com.jmk.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
@ComponentScan(basePackages ="com.jmk")
@EnableConfigurationProperties(AppConfig.class)
public class UserServiceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserServiceApplication.class);

    private final AppConfig appConfig;

    public UserServiceApplication(AppConfig appConfig){
        this.appConfig=appConfig;
    }

    public static void main(String[] args) throws Exception {
    	 SpringApplication.run(UserServiceApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("MySQL hostname  : {} ", appConfig.getHostname());

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}

