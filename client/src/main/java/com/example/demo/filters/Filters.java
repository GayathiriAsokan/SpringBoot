package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * The filter registered by @Component annotation
 * @author GAYATHIRI
 *
 */
@Component
public class Filters  implements Filter {

	/**
	 * It is used to perform request processing
	 */
	@Override
	public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(servletRequest , servletResponse);
	}
	
}

