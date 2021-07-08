/**
 * It is used for pre- and post-processing of controller method invocations and resource handler requests
 */
package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.controller.UserController;

/**
 * It is used for pre- and post-processing of controller method invocations and resource handler requests
 * 
 * @author GAYATHIRI
 *
 */
@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

	Logger log = LoggerFactory.getLogger(UserInterceptor.class);

	/**
	 * Intercept the execution of a handler. Called after HandlerMapping determined an appropriate handler object
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		log.info("Inside the Pre Handle method");
		return true;
	}
	
	/**
	 * Intercept the execution of a handler. Called after HandlerAdapter actually invoked the handle
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {
		log.info("Inside the Post Handle method");
	}
	
	/**
	 * Callback after completion of request processing, that is, after rendering the view
	 */
	@Override
	public void afterCompletion
	(HttpServletRequest request, HttpServletResponse response, Object 
			handler, Exception exception) throws Exception {
		log.info("After completion of request and response");
	}
}