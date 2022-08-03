package com.jmk.auth.security.userdetails;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jmk.auth.feign.client.UserServiceClient;
import com.jmk.user.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceClient userServiceClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ResponseEntity<User> responseEntity = userServiceClient.findUserDetailsByUserName(username);

		User appUser = responseEntity.getBody();
		if (appUser != null) {

			/*
			 * Remember that Spring needs roles to be in this format: "ROLE_" + userRole
			 * (i.e. "ROLE_ADMIN") So, we need to set it to that format, so we can verify
			 * and compare roles (i.e. hasRole("ADMIN")).
			 */
			List<GrantedAuthority> grantedAuthorities = appUser.getRoles().stream()
					.map(role -> "ROLE_" + role.getName()).map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());

			/*
			 * The "User" class is provided by Spring and represents a model class for user
			 * to be returned by UserDetailsService And used by auth manager to verify and
			 * check user authentication.
			 */
			return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(),
					grantedAuthorities);
		}
		// If user not found. Throw this exception.
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}

