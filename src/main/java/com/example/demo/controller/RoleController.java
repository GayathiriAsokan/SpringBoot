/**
 * Provide neccessary to create controller by invoking service
 */
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.Service.RoleService;


/**
 * UserController is used to do the crud operations by invoking service 
 * @author ubuntu
 *
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService; 

	@Autowired 
	LoggerClass logger;


	/**
	 * Get the values from user by invoking roleService 
	 * 
	 * @return -  used to get all users
	 */
	@GetMapping("/get/all")
	public List<Role> getAllUser() {
		return roleService.getAllRole();
	}

	/**
	 * Add  a values by invoking roleService 
	 * 
	 * @param user - which is going to save
	 * @return - used to saved user
	 */
	@PostMapping("/add") 
	private String create(@RequestBody Role role) { 
		return roleService.insertRole(role); 
	}

	/**
	 * Update the values by invoking roleService 
	 * 
	 * @param user  which is going to update
	 * @return - which is updated
	 */
	@PutMapping("/edit") 
	private String edit(@RequestBody Role role) { 
		return roleService.updateRole(role); 
	}

	/**
	 * Delete the values using id by invoking roleService 
	 * 
	 * @param id - which is going to delete
	 * @return - which is deleted
	 */
	@DeleteMapping("/delete/{roleId}")
	private void deleteById(@PathVariable ("roleId") int id) {
		roleService.deleteRole(id);
	}

	/**
	 * Get the value of user by id by invoking roleService 
	 * 
	 * @param id - which is going to delete by id
	 * @return - which is deleted by id
	 */
	@GetMapping("/{roleId}")
	private  Role getById(@PathVariable ("roleId") int id) {
		if (roleService.count() < id) {
			logger.loggerError(Constants.ERROR_MESSAGE);
			throw new CustomException(Constants.ERROR_MESSAGE + "  " +  id);
		}
		return roleService.getRole(id);
	}
}

