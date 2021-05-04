/**
 * 
 */
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.Logger.LoggerClass;


/**
 * DemoApplication is used for main application 
 * @EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation
 * @author ubuntu
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class DemoApplication {
	
	/*
	 * @Autowired static LoggerClass logger;
	 */
	
	/**
	 * Main is used to start the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//logger.loggerInfo("Server started");
	}	 

}
