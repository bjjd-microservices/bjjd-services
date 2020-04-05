package com.jmk.account;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.jmk" })
public class AccountMgmtRestApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplication(AccountMgmtRestApplication.class).run(args);
    }

    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
