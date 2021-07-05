/**
 * Provide neccessary to create controller by invoking service
 */
package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.Constants;
import com.example.demo.Exception.CustomException;
import com.example.demo.Model.Role;
import com.example.demo.Service.RoleService;


/**
 * UserController is used to do the crud operations by invoking service 
 * @author GAYATHIRI
 *
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

	Logger log = LoggerFactory.getLogger(RoleController.class);	
	
	@Autowired
	private RoleService roleService; 

	/**
	 * Get the values from user by invoking roleService 
	 * 
	 * @return -  used to get all users
	 */
	@GetMapping("/getallRoles")
	public List<Role> getallRoles() {
		return roleService.getAllRole();
	}

	/**
	 * Add  a values by invoking roleService 
	 * 
	 * @param user - which is going to save
	 * @return - used to saved user
	 */
	@PostMapping("/addRoles") 
	private Role createRoles(@RequestBody Role role) { 
		return roleService.insertRole(role); 
	}

	/**
	 * Update the values by invoking roleService 
	 * 
	 * @param user  which is going to update
	 * @return - which is updated
	 */
	@PutMapping("/editRoles") 
	private Role editRoles(@RequestBody Role role) { 
		return roleService.updateRole(role); 
	}

	/**
	 * Delete the values using id by invoking roleService 
	 * 
	 * @param id - which is going to delete
	 * @return - which is deleted
	 */
	@DeleteMapping("/deleteRoles/{roleId}")
	private void deleteRolesById(@PathVariable ("roleId") int id) {
		roleService.deleteRole(id);
	}

	/**
	 * Get the value of user by id by invoking roleService 
	 * 
	 * @param id - which is to get by id
	 * @return - which is get by id
	 */
	@GetMapping("/getRolesById/{roleId}")
	private  Role getRolesById(@PathVariable ("roleId") int id) {
		if (roleService.count(id) != 1) {
			log.error(Constants.ERROR_MESSAGE);
			throw new CustomException(Constants.ERROR_MESSAGE + "  " +  id);
		}
		return roleService.getRole(id);
	}

	/**
	 * Add users to roles
	 * 
	 * @param role
	 * @return
	 */
	@PostMapping("/addRoles/userRole") 
	private Role userRole(@RequestBody Role role) {
		System.out.println(role);
		return roleService.userRoles(role);
	}	
}

