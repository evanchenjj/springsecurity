package com.evan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @author chenjijiang
 * @date 2019/10/31
 * @description
 */
@Configuration
@EnableResourceServer

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class CustomResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setClientId("my-client-1");
		tokenServices.setClientSecret("$2a$07$NBwQJhJoaJb7CDfH0rvq7.C9r6i92trevP0z/8dM25Zlv7/iR1xkO");
		tokenServices.setCheckTokenEndpointUrl("localhost:8081/oauth/check_token");
		resources.tokenServices(tokenServices);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests().anyRequest().permitAll();
//				.and().authorizeRequests().antMatchers("/userList").hasAnyAuthority("ROLE_USER");
	}
}
