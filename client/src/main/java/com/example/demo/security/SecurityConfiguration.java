package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
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

	/**avaru meeting la upd
	 * SecurityBuilder  used to create an AuthenticationManager
	 *  Allows for easily building in memory authentication
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception 
	{
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("root")
		.roles("USER");
	}

	/**
	 * PasswordEncoder is defined in the Spring Security configuration to encode the password
	 * @return
	 **/
	@Bean 
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}