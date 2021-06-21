/**
 * Provide necessary to handle exception globally
 * @version 1.1
 */
package com.example.demo.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Exception.CustomException;
import com.example.demo.Model.ErrorResponse;

/**
 * To handle exceptions across the whole application in global handling component
 * @author GAYATHIRI
 *
 */
@RestControllerAdvice
public class RestExceptionHandler {

	@Autowired
	private ErrorResponse error;
	
	/**
	 * It is used to handle the runtime exception and send it to response entity
	 * 
	 * @param exception
	 * @return Http response for objects
	 */
	@ExceptionHandler
	public ResponseEntity <ErrorResponse> handleException(RuntimeException exception) {
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
	/**
	 * It is used to handle the file not exception and send it to response entity
	 * 
	 * @param exception
	 * @return Http response for objects
	 */
	@ExceptionHandler
	public ResponseEntity <ErrorResponse> resourceNotFoundException(ConfigDataResourceNotFoundException exception) {
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("File Not Found");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND) ;
	}

	/**
	 * It is used to handle the exception and send to response entity
	 * @param exception
	 * @return Http response for objects
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> useIdExsit(CustomException exception) {
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
	}
}
