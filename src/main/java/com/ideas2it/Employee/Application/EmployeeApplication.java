package com.ideas2it.Employee.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Employee Application is start of the application 
 * @author ubuntu
 *
 */
@SpringBootApplication
public class EmployeeApplication {

	/**
	 * Main method is used to run employee apllication class
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		System.out.println("hi spring boot");
	}

}
