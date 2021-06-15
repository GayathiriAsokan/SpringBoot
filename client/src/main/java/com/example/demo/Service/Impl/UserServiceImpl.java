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
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Constants;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.controller.UserController;


/**
 * UserServiceImpl is used to do crud operations in service 
 * @author ubuntu
 *
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	private static final org.apache.logging.log4j.Logger log = 
			org.apache.logging.log4j.LogManager.getLogger(UserController.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAll() {
		try {
			log.info("Method to view");
			List <User> user = new ArrayList(userRepository.findAll());
			System.out.println(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User insertUser(User user) {
		try {
			log.info("Method to insert");
			return userRepository.save(user);
			//return Constants.INSERT_MESSAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updateUser(User user) {
		try {
			log.info("Method to update");
			return userRepository.save(user);
			//return Constants.UPDATE_MESSAGE;
		} catch (Exception e) {
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
			log.info("Method to delete");
			userRepository.deleteById(userId);
			return Constants.DELETE_MESSAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getById(String userId) {
		try {
			Optional<User> user = userRepository.findById(userId);
			return user.get();  
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return id;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String userRoles(User user) {
		try {
			userRepository.save(user);
			return Constants.INSERT_MESSAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
