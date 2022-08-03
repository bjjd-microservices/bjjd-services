package com.jmk.auth.security.filters;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.auth.security.config.JwtConfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	// We use auth manager to validate the user credentials
	private AuthenticationManager authenticationManager;
	
	private final JwtConfig jwtConfig;

	public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtConfig = jwtConfig;
		// By default, UsernamePasswordAuthenticationFilter listens to "/login" path. 
		// In our case, we use "/auth". So, we need to override the defaults.
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(),"POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			//1. Get credentials from request
			UserCredentials userCredentials=new ObjectMapper().readValue(request.getInputStream(),UserCredentials.class);
			//2. Create auth object (contains credentials) which will be used by auth manager
			UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),userCredentials.getPassword(),Collections.emptyList());
			//3. Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user.
	        return authenticationManager.authenticate(authToken);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Upon successful authentication, generate a token.
    // The 'auth' passed to successfulAuthentication() is the current authenticated user.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		Long now=System.currentTimeMillis();
		String token=Jwts.builder()
				.setSubject(authentication.getName())
				// Convert to list of strings.
                // This is important because it affects the way we get them back in the Gateway.
				.claim("authorities",authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now+jwtConfig.getExpiration()*1000))
				.signWith(SignatureAlgorithm.HS512,jwtConfig.getSecret().getBytes())
				.compact();
		
		// Add token to header
		response.setHeader(jwtConfig.getHeader(),jwtConfig.getPrefix()+token);
	}

	private static class UserCredentials{
		private String username;
		private String password;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
}
