/**
 * Provide necessary to load the configuration properties value from the Config server.
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To load the configuration properties value from the Config server.
 * 
 * @author GAYATHIRI
 */
@RestController
@RefreshScope
public class ConfigclientApplication {
	
	@Value("${message: Default springboot hii}")
    private String message;

	/**
	 * Get the message from config properties
	 * @return
	 */
	  @GetMapping("/getconfigvalues") 
	  public String getconfigvalues () { 
		  return message;
	  }
}
