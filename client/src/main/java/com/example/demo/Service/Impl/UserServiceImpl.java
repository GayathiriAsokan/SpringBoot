/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.example.demo.Service.Impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Constants;
import com.example.demo.Model.Role;
import com.example.demo.Model.UserDetails;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.controller.AOP.TrackEntity;
import com.example.demo.controller.UserController;

/**
 * UserServiceImpl is used to do crud operations in service 
 * @author GAYATHIRI
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserDetails> getAll() {
		try {
			List <UserDetails> user = (List<UserDetails>) userRepository.findAll();
			return user;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@TrackEntity
	public UserDetails insertUser(UserDetails user) {
		try {
			return userRepository.save(user);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@TrackEntity
	public UserDetails updateUser(UserDetails user) {
		try {
			return userRepository.save(user);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteUser(String userId) {
		try {	
			userRepository.deleteById(userId);
			return Constants.DELETE_MESSAGE;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails getById(String userId) {
		try {
			Optional<UserDetails> user = userRepository.findById(userId);
			return user.get();  
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count(String userId) {
		Long id = 0l;
		try {
			id = userRepository.countUser(userId);
			if (null != id &&  id != 0) {
			return  id;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
		return id;

	}

	/**
	 * {@inheritDoc}
	 */
	@TrackEntity
	@Override
	public String userRoles(UserDetails user) {
		try {
			userRepository.save(user);
			return Constants.INSERT_MESSAGE;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
