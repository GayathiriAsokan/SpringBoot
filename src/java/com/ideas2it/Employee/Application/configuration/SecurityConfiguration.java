package com.ideas2it.Employee.Application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfiguration  is used for authentication
 * @author ubuntu
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/**
	 * SecurityBuilder  used to create an AuthenticationManager
	 *  Allows for easily building in memory authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder authenticate) throws Exception {
		authenticate.inMemoryAuthentication()
				.withUser("user")
				.password("root").roles("USER");
	}
	
	/**
	 * PasswordEncoder is defined in the Spring Security configuration to encode the password
	 * @return
	 */
	@Bean 
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	 
	/**
	 *  It is used for configuring web based security for specific http requests
	 */
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/").hasRole("USER").and().formLogin();
	}
	
}
