/**
 * 
 */
package com.ideas2it.Employee.Application.service;

import java.util.Optional;

import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.Role;

/**
 * @author ubuntu
 *
 */
public interface RoleService {
    
	/**
	 * Insert a role for employee
	 * @param roleId
	 * @param roleName
	 * @return
	 */
	public String insertRole(int employeeId, String roleName);
	
	/**
	 * Update a role for employee
	 * @param employeeId
	 * @param projectId
	 * @return
	 */
	public String updateRole(int employeeId, int projectId);
}
