package com.ideas2it.Employee.Application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Role is  uesd to create  a role  for Employee
 * @author ubuntu
 *
 */
@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId ;
	
	@Column(name="role_name")
	private String  roleName;	
	
	@Column(name="employee_id")
	private int employeeId;
	
	/**
	 * Default Constructor
	 */
	public Role() {
		
	}

	/**
	 * Parameterized constructor
	 * @param roleId
	 * @param roleName
	 * @param employeeId
	 */
	public Role( String roleName, int employeeId) {
		this.roleName = roleName;
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", employeeId=" + employeeId + "]";
	}
}
