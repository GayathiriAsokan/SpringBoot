/**
 * 
 */
package com.example.demo;

import java.lang.annotation.Annotation;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.Model.User;

/**
 * DemoApplication is used for main application 
 * @EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation
 * @author ubuntu
 *
 */
@SpringBootApplication 
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	/**
	 * Main is used to start the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.warn("Spring Boot started");
		/*
		 * User user = new User(); Class c = user.getClass(); Annotation annotation =
		 * c.getAnnotation(Address.class); System.out.println(annotation);
		 */
	}	 
}
