/**
 * Provide necessary to create a logger class to find find error easily
 */
package com.example.demo.Logger;

import org.jboss.logging.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.demo.Model.User;

/**
 * @description Logger class is used for sent the information and error messages
 * @author GAYATHIRI
 *
 */
@Component
@ConfigurationProperties
public class LoggerClass {
	private Logger logger = Logger.getLogger(LoggerClass.class);

	/**
	 * To display error message from logger
	 */
	 public void loggerError(String message) {
		 logger.error(message);
	 } 
	  
	 /**
	  * To display info message from logger
	  */
	 public void loggerInfo(String message) {
		 logger.info(message);
	 }
     
	 /**
	  *  To display info user from logger
	  */
	 public void logger(User user) {
		 logger.info(user);
	 }
	 
	 /**
	  *  This error can simply not continue the  appliication
	  */
      public void loggerFatal(String message) {
    	  logger.fatal(message);
      }
}

