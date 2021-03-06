package com.example.demo.security.filters;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.util.JwtUtil;
import com.example.demo.Service.Impl.MyUserDetailsServiceImpl;

/**
 * The JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter class
 * For any incoming request this Filter class gets executed 
 * It checks if the request has a valid JWT token
 * It sets the Authentication in the context, to specify that the current user is authenticated.
 * 
 * @author GAYATHIRI
 *
 */
@Component
public class JwtRequestFilter  extends OncePerRequestFilter {

	Logger log = LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    
	/**
	 * It checks if the request has a valid JWT token
	 * It sets the Authentication in the context, to specify that the current user is authenticated
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
		filterChain.doFilter(request , response);
	}
}

