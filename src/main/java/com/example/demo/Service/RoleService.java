/**
 * 
 */
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Role;



/**
 * @author ubuntu
 *
 */
public interface RoleService {
    
	/**
	 * Insert a role for role
	 * @param role
	 * @return
	 */
	public String insertRole(Role role);
	
	/**
	 * Delete the roles
	 * @param roleId
	 * @return
	 */
	public String deleteRole(int roleId);
	
	/**
	 * Update a role for role
	 * @param role
	 * @return
	 */
	public String updateRole(Role role);
	
	/**
	 * Get the values from role
	 * @param roleId
	 * @return
	 */
	public Role getRole(int roleId);
	
	/**
	 *  Get all roles
	 * @return
	 */
	public List <Role>  getAllRole();
	
	/**
	 * get count of roles
	 * @return
	 */
	public int count();
}
