/**
 * Provide necessary class to create Exception to define the user defined exception
 */
package com.example.demo.Exception;

/**
 * @description CustomException is used to print the user defined exception
 * @author GAYATHIRI
 * @return String
 */
public class CustomException extends RuntimeException{
	private String message;
	
	/**
	 * Asigning values using super keyword    
	 * @param message
	 */
	public CustomException(String message) {
		super(message);
	}
}
