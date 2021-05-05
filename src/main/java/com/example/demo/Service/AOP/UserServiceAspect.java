package com.example.demo.Service.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Logger.LoggerClass;
import com.example.demo.Model.User;

/**
 * Adding some additional behaviour in existing code without modify the code itself
 * @author ubuntu
 *
 */
@Aspect  
@Component  
public class UserServiceAspect {

	@Autowired
	LoggerClass logger;
	/**
	 * 
	 * @param joinPoint
	 * @param user
	 *
	@Before(value = "execution(* com.example.demo.Service.UserService.*(..)) and args(user)")
	public void  beforeAdvice(JoinPoint joinPoint, User user) {
		logger.loggerInfo("Before method:" + joinPoint.getSignature());
		logger.loggerInfo("Creating User with userId - " + user);  
	}
	
	/**
	 * Displays all the available methods i.e. the advice will be called for all the methods
	 */
	@Pointcut(value= "execution(* com.example.demo.Service.UserService.*(..))")  
	private void logUserService()   
	{   
	}  
	  
	/**
	 * Declares the around advice that is applied before and after the method matching with a pointcut expression
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Around(value= "logUserService()")  
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable   
	{  
		logger.loggerInfo("The method aroundAdvice() before invokation of the method " + joinPoint.getSignature().getName() + " method");  
	try   
	{  
		joinPoint.proceed();  
	}   
	finally   
	{  
	  
	}  
	logger.loggerInfo("The method aroundAdvice() after invokation of the method " + joinPoint.getSignature().getName() + " method");  
	}
	
	/**
	 * Implementing after returning advice     
	 * @param joinPoint
	 * @param account
	  */
	@AfterReturning(value="execution(* com.example.demo.Service.UserService.*(..))",returning="user")  
	public void afterReturningAdvice(JoinPoint joinPoint, User user)  
	{  
		logger.loggerInfo("After Returing method:"+joinPoint.getSignature());  
		logger.logger(user);  
	} 
}
