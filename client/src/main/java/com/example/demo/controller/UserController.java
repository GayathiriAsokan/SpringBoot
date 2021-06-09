/**
 * Provide neccessary to create controller by invoking service
 */
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.xml.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.example.demo.Constants.Constants;
import com.example.demo.Exception.CustomException;
import com.example.demo.Logger.LoggerClass;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Model.UserErrorResponse;
import com.example.demo.Service.UserService;


/**
 * UserController is used to do the crud operations by invoking service 
 * @author ubuntu
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService; 

	@Autowired
	LoggerClass logger;
   
	@Value("${message: Default springboot hii}")
    private String message;
	
	/**
	 * Get the values from user by invoking userService 
	 * 
	 * @return -  used to get all users
	 */
	@GetMapping("/get/all")
	public List<User> getAllUser() {
		System.out.println(userService.getAll());
		return userService.getAll();
	}

	
	  @GetMapping("/gg") 
	  public String g () { 
		  return message;
	  
	  }
	 

	/**
	 * Add  a values by invoking userService 
	 * 
	 * @param user - which is going to save
	 * @return - used to saved user
	 */
	@PostMapping("/add") 
	private String create(@RequestBody User user) { 
		return userService.insertUser(user); 
	}

	/**
	 * Update the values by invoking userService 
	 * 
	 * @param user  which is going to update
	 * @return - which is updated
	 */
	@PutMapping("/edit") 
	private String edit(@RequestBody User user) { 
		return userService.updateUser(user); 
	}

	/**
	 * Delete the values using id by invoking userService 
	 * 
	 * @param id - which is going to delete
	 * @return - which is deleted
	 */
	@DeleteMapping("/delete/{userId}")
	private void deleteById(@PathVariable ("userId") String id) {
		userService.deleteUser(id);
	}

	/**
	 * Get the value of user by id by invoking userService 
	 * 
	 * @param id - which is going to delete by id
	 * @return - which is deleted by id
	 */
	@GetMapping("/{userId}")
	private  User getById(@PathVariable ("userId") String id) {
		String string = Character.toString(id.charAt(5)); 
		if (userService.count() < Integer.parseInt(string)) {
			logger.loggerError(Constants.ERROR_MESSAGE);
			throw new CustomException(Constants.ERROR_MESSAGE + "  " +  id);
		}
		return userService.getById(id);
	}

	/**
	 * Add roles to users
	 * @param user
	 * @return
	 */
	@PostMapping("/add/userRole") 
	private String userRole(@RequestBody User user) {
		System.out.println(user);
		return userService.userRoles(user);
	}	
}
