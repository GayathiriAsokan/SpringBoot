/**
 * Provide neccessary to create controller by invoking service
 */
package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.xml.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.Constants.Constants;
import com.example.demo.Exception.CustomException;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Model.ErrorResponse;
import com.example.demo.Service.UserService;


/**
 * UserController is used to do the crud operations by invoking service 
 * @author GAYATHIRI
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService; 

	/**
	 * Get the values from user by invoking userService 
	 * 
	 * @return -  used to get all users
	 */
	@GetMapping("/getallUsers")
	public List<User> getAllUser() {
		return userService.getAll();
	}

	/**
	 * Add  a values by invoking userService 
	 * 
	 * @param user - which is going to save
	 * @return - used to saved user
	 */
	@PostMapping("/addUser") 
	private User createUser(@RequestBody User user) { 
		return userService.insertUser(user); 
	}

	/**
	 * Update the values by invoking userService 
	 * 
	 * @param user  which is going to update
	 * @return - which is updated
	 */
	@PutMapping("/editUser") 
	private User editUser(@RequestBody User user) { 
		return userService.updateUser(user); 
	}

	/**
	 * Delete the values using id by invoking userService 
	 * 
	 * @param id - which is going to delete
	 * @return - which is deleted
	 */
	@DeleteMapping("/deleteUser/{userId}")
	private void deleteUserById(@PathVariable ("userId") String id) {
		userService.deleteUser(id);
	}

	/**
	 * Get the value of user by id by invoking userService 
	 * 
	 * @param id - which is to retrieve by id
	 * @return - which is retrieve by id
	 */
	@GetMapping("getUserById/{userId}")
	private  User getUserById(@PathVariable ("userId") int idValue) {
		String id = "user_" + idValue;
		if (userService.count(id) ==  1) {
			return userService.getById(id);
		} else {
			log.error(Constants.ERROR_MESSAGE);
			throw new CustomException(Constants.ERROR_MESSAGE + "  " +  idValue);
		}
	}

	/**
	 * Add roles to users
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/addUser/userRole") 
	private String userRole(@RequestBody User user) {
		System.out.println(user);
		return userService.userRoles(user);
	}
}
