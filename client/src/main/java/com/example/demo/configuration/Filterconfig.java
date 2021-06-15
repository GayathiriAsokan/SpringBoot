package com.example.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.Filters;

/**
 *  To filter class definition and register the filter using a FilterRegistrationBean
 * @author GAYATHIRI
 *
 */
public class Filterconfig {
	@Configuration
	public class MyFilterConfig {
		
		/**
		 *  To filter class definition and register the filter using a FilterRegistrationBean
		 */
		@Bean
		public FilterRegistrationBean<Filters> registrationBean() {
			FilterRegistrationBean<Filters> registrationBean = new FilterRegistrationBean<>();
			registrationBean.setFilter(new Filters());
			registrationBean.addUrlPatterns("/*");
			return registrationBean;
		}
	}
}
