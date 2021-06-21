package com.example.demo.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The filter registered by @Component annotation
 * @author GAYATHIRI
 *
 */
@Component
public class LoggingFilter  implements Filter {

	Logger log = LoggerFactory.getLogger(LoggingFilter.class);

	/**
	 * It is used to perform request processing
	 */
	@Override
	public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		log.info("Request information " , request.getMethod()
				, request.getServerPort()
				,request.getRequestURI()
				,request.getRequestURL());
		chain.doFilter(servletRequest , servletResponse);
		log.info("Response information" ,
				response.getContentType(),
				response.getStatus());
		System.out.println("Remote Host:"+servletRequest.getRemoteHost());
	      System.out.println("Remote Address:"+servletRequest.getRemoteAddr());
	}

}

