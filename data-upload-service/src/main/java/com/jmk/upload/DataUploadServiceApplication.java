package com.jmk.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.jmk.upload.config.properties.FileStorageProperties;
import com.jmk.upload.ribbon.config.RibbonConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@AutoConfigureAfter(RibbonAutoConfiguration.class)
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@EnableFeignClients(basePackages = "com.jmk")
@ComponentScan(basePackages = { "com.jmk" })
public class DataUploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataUploadServiceApplication.class, args);
	}
	
}


