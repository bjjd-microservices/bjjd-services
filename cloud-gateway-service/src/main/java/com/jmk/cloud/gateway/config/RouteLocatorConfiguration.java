package com.jmk.cloud.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("deprecation")
@Configuration
public class RouteLocatorConfiguration {
	
	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/user-service/user/**")
				.filters(f -> f.filter(filterFactory.apply())
						.removeRequestHeader("Cookie"))
				.uri("lb://user-service") //.uri("http://127.0.0.1:3379")
				.id("user-service"))

				.route(r -> r.path("/api/project-service/project/**")
				.filters(f -> f.filter(filterFactory.apply())
				.removeRequestHeader("Cookie"))
				.uri("lb://project-service/")//.uri("http://127.0.0.1:5379")
				.id("project-service"))
				.build();
	}
		
}

