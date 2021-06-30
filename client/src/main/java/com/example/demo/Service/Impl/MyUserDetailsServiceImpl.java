/**
 * Provide necessary to create service class to communicate with user Rpository
 */
package com.example.demo.Service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Model.UserPrincipal;
import com.example.demo.Repository.UserRepository;

/**
 * It is used to get the username from user repository
 * 
 * @author GAYATHIRI
 *
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService{


	@Autowired 
	UserRepository userRepository;

	/**
	 * It is implemented method to get the username from user repository
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserName(username);
		if (user == null) { 
			throw new UsernameNotFoundException("USER 404", null); }
		return new UserPrincipal(user);
	}

}
