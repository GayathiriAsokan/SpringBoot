/**
 * 
 */
package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * DemoApplication is used for main application 
 * @EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation
 * @author GAYATHIRI
 *
 */
@SpringBootApplication 
@EnableAspectJAutoProxy(proxyTargetClass=true)  
@EnableSwagger2
public class DemoApplication {
	/**
	 * Main is used to start the spring boot application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}	
	
	/**
	 * Swagger used to show the document of api
	 * @return
	 */
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	   }
}