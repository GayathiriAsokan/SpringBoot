/**
 * Configuration class file to register the Interceptor into Interceptor Registry
 * 
 * version 1.0
 */
package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application Configuration class file to register the Interceptor into Interceptor Registry
 * 
 * @author GAYATHIRI
 *
 */
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	   
	 @Autowired
	 UserInterceptor interceptor;
	 
	 /**
	  * It is used for pre- and post-processing of controller method invocations and resource handler requests
	  */
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(interceptor);
	   }
	}


