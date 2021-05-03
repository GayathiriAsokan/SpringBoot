/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Constants;
import com.example.demo.Logger.LoggerClass;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

/**
 * UserServiceImpl is used to do crud operations in service 
 * @author ubuntu
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LoggerClass logger;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAll() {
		logger.loggerInfo("Method to view");
		return userRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String insertUser(User user) {
		logger.loggerInfo("Method to insert");
		userRepository.save(user);
		return Constants.INSERT_MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String updateUser(User user) {
		logger.loggerInfo("Method to update");
		userRepository.save(user);
		return Constants.UPDATE_MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteUser(String userId) {
		logger.loggerInfo("Method to delete");
		userRepository.deleteById(userId);
		return Constants.DELETE_MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getById(String userId) {
		Optional<User> user = this.userRepository.findById(userId);
		return user.get();  
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int count() {
		return (int) userRepository.count();
	}
}
