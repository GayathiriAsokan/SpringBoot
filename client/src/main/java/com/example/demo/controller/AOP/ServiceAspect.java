/**
 * Provide necessay to create AOP with service 
 * 
 */
package com.example.demo.controller.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;

/**
 * Adding some additional behaviour in existing code without modify the code itself
 * @author GAYATHIRI
 *
 */
@Aspect  
@Component
public class ServiceAspect {

	Logger log = LoggerFactory.getLogger(ServiceAspect.class); 

	/**
	 * This method is invoked before and after method
	 * 
	 * @param joinPoint
	 * @param user
	 */
	@Around("@annotation(com.example.demo.controller.AOP.TrackEntity) && (args(user))")
	public void  aroundAdvice(JoinPoint joinPoint, User user) {
		log.info("Before and After method:" + joinPoint.getSignature());
		log.info("Creating User with userId - " + user); 
	}
}
