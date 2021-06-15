/**
 * 
 */
package com.example.demo.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Role;

/**
 * Necessary to create role service for roles
 * @author GAYATHIRI
 *
 */
public interface RoleService {
    
	/**
	 * Insert a role for role
	 * @param role
	 * @return
	 */
	public Role insertRole(Role role);
	
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
	public Role updateRole(Role role);
	
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
	public Long count(int roleId);

	/**
	 * Add users to roles
	 * @param role
	 * @return
	 */
	public Role userRoles(Role role);
}
