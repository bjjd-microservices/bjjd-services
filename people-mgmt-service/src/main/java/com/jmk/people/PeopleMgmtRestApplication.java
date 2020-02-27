package com.jmk.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages ="com.jmk")
public class PeopleMgmtRestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PeopleMgmtRestApplication.class,args);
    }

}
