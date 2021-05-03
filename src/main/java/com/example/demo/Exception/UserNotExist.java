/**
 * Provide necessary class to create Exception to define the user defined exception
 */
package com.example.demo.Exception;

/**
 * @description CustomException is used to print the user defined exception
 * @author GAYATHIRI
 * @return String
 */
public class UserNotExist extends RuntimeException{
	private String message;
	
	/**
	 * Asigning values using this keyword    
	 * @param message
	 */
	public UserNotExist(String message) {
		super(message);
	}
}
