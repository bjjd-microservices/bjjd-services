package com.jmk.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfiguration {
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/user-service/user/**")
				.uri("lb://user-service") //.uri("http://127.0.0.1:3379")
				.id("user-service"))

				.route(r -> r.path("/api/project-service/project/**")
				.uri("lb://project-service/"). //.uri("http://127.0.0.1:5379")
				id("project-service"))
				.build();
	}
	
	
}

