/**
 * 
 */
package com.ideas2it.Employee.Application.service;

import java.util.List;
import java.util.Optional;

import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.Role;

/**
 * @author ubuntu
 *
 */
public interface RoleService {
    
	/**
	 * Insert a role for role
	 * @param roleId
	 * @param roleName
	 * @return
	 */
	public String insertRole(int employeeId, String roleName);
	
	/**
	 * Update a role for role
	 * @param employeeId
	 * @param projectId
	 * @return
	 */
	public String updateRole(int employeeId, int projectId);
	
	/**
	 * Get the values from role
	 * @param employeeId
	 * @return
	 */
	public Role getRole(int employeeId);
	
	/**
	 *  Get all roles
	 * @return
	 */
	public List <Role>  getAllRole();
	
}
