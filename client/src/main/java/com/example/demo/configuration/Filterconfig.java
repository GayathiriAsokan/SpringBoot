package com.example.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.filters.LoggingFilter;

/**
 *  To filter class definition and register the filter using a FilterRegistrationBean
 * @author GAYATHIRI
 *
 */
@Configuration
public class Filterconfig {
	
		/**
		 *  To filter class definition and register the filter using a FilterRegistrationBean
		 */
		@Bean
		public FilterRegistrationBean<LoggingFilter> registrationBean() {
			FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
			registrationBean.setFilter(new LoggingFilter());
			registrationBean.addUrlPatterns("/*");
			return registrationBean;
		}
}
