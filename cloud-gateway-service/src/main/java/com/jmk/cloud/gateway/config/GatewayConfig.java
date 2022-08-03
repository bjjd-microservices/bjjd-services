package com.jmk.cloud.gateway.config;

import java.net.HttpCookie;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

	@SuppressWarnings("deprecation")
	@Bean("requestHeaderFilter")
	public GatewayFilter customGlobalFilter() {
		return (exchange, chain) -> exchange.getPrincipal().map(principal -> {

			String emailId = "";
			String session = "";
			String userName = "";

			if (principal instanceof JwtAuthenticationToken) {
				// Get username from Principal
				userName = ((JwtAuthenticationToken) principal).getToken().getClaimAsString("preferred_username");
				// emailId = principal1.getUserInfo().getEmail();
				// Adding cookies
				session = new HttpCookie("SESSION", exchange.getSession().block().getId()).toString();

			}
			// adds header to proxied request
			exchange.getRequest().mutate().header("username", new String[] { userName })
					.header("X-Auth-Email", new String[] { emailId }).header("cookie", session).build();
			return exchange;
		}).flatMap(chain::filter).then(Mono.fromRunnable(() -> {

		}));
	}
}

