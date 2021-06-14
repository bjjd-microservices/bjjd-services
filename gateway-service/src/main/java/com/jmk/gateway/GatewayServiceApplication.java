package com.jmk.gateway;

import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

import com.jmk.gateway.ribbon.config.RibbonConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient  // It acts as a eureka client
@EnableZuulProxy     // Enable Zuul
@EnableSwagger2
@AutoConfigureAfter(RibbonAutoConfiguration.class)
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@ComponentScan(basePackages = { "com.jmk" })
@SpringBootApplication
public class GatewayServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GatewayServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Autowired
	DiscoveryClient client;

	@PostConstruct
	public void init() {
		LOGGER.info("Services: {}", client.getServices());
		Stream<ServiceInstance> s = client.getServices().stream().flatMap(it -> client.getInstances(it).stream());
		s.forEach(it -> LOGGER.info("Instance: url={}:{}, id={}, service={}", it.getHost(), it.getPort(), it.getInstanceId(), it.getServiceId()));
	}

}

