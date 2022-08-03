package com.jmk.cloud.gateway.config;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("deprecation")
@Configuration
public class RouteLocatorConfiguration {
	
	@Resource(name="requestHeaderFilter")
	private GatewayFilter gatewayFilter;
	
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
						.filters(f -> f.filter(gatewayFilter))
						.uri("lb://project-service/")
						.id("project-service"))
				
				.route(r -> r.path("/api/people-service/**")
						.filters(f -> f.filter(gatewayFilter))
						.uri("lb://people-service/")
						.id("people-service"))
				
				.route(r -> r.path("/api/darshan-service/**")
						.filters(f -> f.filter(gatewayFilter))
						.uri("lb://darshan-service/")
						.id("darshan-service"))
				
				.route(r -> r.path("/api/account-service/**")
						.filters(f -> f.filter(gatewayFilter))
						.uri("lb://account-service/")
						.id("account-service"))
				
				.route(r -> r.path("/api/data-upload-service/**")
						.filters(f -> f.filter(gatewayFilter))
						.uri("lb://data-upload-service/")
						.id("data-upload-service"))
		
				.build();
	}
		
}

