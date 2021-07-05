package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class InterceptorConfig extends WebMvcConfigurerAdapter {
	   
	 @Autowired
	 UserInterceptor interceptor;
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
		   
	      registry.addInterceptor(interceptor);
	   }
	}


