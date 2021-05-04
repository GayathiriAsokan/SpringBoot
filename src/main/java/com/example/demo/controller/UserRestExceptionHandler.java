package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.UserNotExist;
import com.example.demo.Model.UserErrorResponse;

@ControllerAdvice
public class UserRestExceptionHandler {

	@Autowired
	private UserErrorResponse error;
	
	/**
	 * It is used to handle the exception and send to response entity
	 * @param exception
	 * @return Http response for objects
	 */
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotExist exception) {
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND) ;
	}
}
