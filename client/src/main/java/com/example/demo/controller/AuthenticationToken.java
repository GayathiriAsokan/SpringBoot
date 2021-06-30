/**
 * Passing validate username and password it will generate a JSON Web Token
 * 
 * version 1.0
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.JwtUtil;
import com.example.demo.Model.AuthenticationRequest;
import com.example.demo.Model.AuthenticationResponse;
import com.example.demo.Service.Impl.MyUserDetailsServiceImpl;

/**
 * To validate user name and password 
 * Generating Json web token
 * 
 * @author GAYATHIRI
 *
 */
@RestController
public class AuthenticationToken {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsServiceImpl userDetailsService;

	/**
	 * To authenticate the user and generate jwt token
	 * 
	 * @param authenticationRequest 
	 *            send authentication request for user name and password 
	 * @return 
	 *            response message 
	 * @throws Exception
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username oreclipse-javadoc:%E2%98%82=demo/src%5C/main%5C/java=/optional=/true=/=/maven.pomderived=/true=/%3Ccom.example.demo.controller password", e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
