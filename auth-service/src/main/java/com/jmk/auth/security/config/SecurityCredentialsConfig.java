package com.jmk.auth.security.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jmk.auth.security.filters.JwtUsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;

	/*
	 * Spring has UserDetailsService interface, which can be overriden to provide
	 * our implementation for fetching user from database (or any other source). The
	 * UserDetailsService object is used by the auth manager to load the user from
	 * database. In addition, we need to define the password encoder also. So, auth
	 * manager can compare and verify passwords.
	 */@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				// make sure we use stateless session; session won't be used to store user's
				// state.
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// handle an authorized attempts
				.exceptionHandling()
				.authenticationEntryPoint(
						(request, response, exception) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and()
				/*
				 * Add a filter to validate user credentials and add token in the response
				 * header authenticationManager()= An object provided by
				 * WebSecurityConfigurerAdapter, used to authenticate the user passing user's
				 * credentials The filter needs this auth manager to authenticate the user.
				 */
				.addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig))
				.authorizeRequests()
				// allow all POST requests
				.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
				// any other requests must be authenticated
				.anyRequest().authenticated();
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
