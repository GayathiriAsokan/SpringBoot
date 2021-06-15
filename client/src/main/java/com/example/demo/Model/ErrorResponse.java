/**
 * Provide necessary to create entity to get the response error
 */
package com.example.demo.Model;

import javax.persistence.Entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * UserErrorResponse is used to get response from restService 
 * @author GAYATHIRI
 *
 */
@Component
@ConfigurationProperties
public class ErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	
	public ErrorResponse() {
		
	}
	
	public ErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "UserErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
}
