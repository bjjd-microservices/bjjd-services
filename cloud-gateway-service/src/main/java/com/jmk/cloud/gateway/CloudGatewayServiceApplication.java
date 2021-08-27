package com.jmk.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import reactor.core.publisher.Mono;

@ComponentScan(basePackages = { "com.jmk" })
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class CloudGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServiceApplication.class, args);
	}
	
	@GetMapping(value = "/token")
	public Mono<Model> getHome(@AuthenticationPrincipal OidcUser oidcUser, Model model,@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
		model.addAttribute("username", oidcUser.getName());
        model.addAttribute("idToken", oidcUser.getIdToken().getTokenValue());
        model.addAttribute("accessToken", authorizedClient.getAccessToken().getTokenValue());
		return Mono.just(model);
	}

	@GetMapping("/")
	public Mono<String> index(WebSession session) {
		return Mono.just(session.getId());
	}
	
}

