package com.example.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.Filters;

public class Filterconfig {
	@Configuration
	public class MyFilterConfig {
		
		@Bean
		public FilterRegistrationBean<Filters> registrationBean() {
			FilterRegistrationBean<Filters> registrationBean = new FilterRegistrationBean<>();
			registrationBean.setFilter(new Filters());
			registrationBean.addUrlPatterns("/*");
			return registrationBean;
		}

	}
}
