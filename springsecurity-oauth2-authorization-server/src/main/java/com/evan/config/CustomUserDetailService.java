package com.evan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjijiang
 * @date 2019/10/31
 * @description
 */
@Configuration
public class CustomUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(username,"$2a$07$NBwQJhJoaJb7CDfH0rvq7.C9r6i92trevP0z/8dM25Zlv7/iR1xkO",list);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(7);
	}

	/*public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(7);
		System.out.println(passwordEncoder.encode("1234567"));
	}*/
}
