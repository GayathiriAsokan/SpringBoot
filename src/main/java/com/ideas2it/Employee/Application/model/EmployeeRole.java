package com.ideas2it.Employee.Application.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_role")
public class EmployeeRole {

	@Id
	@Column(name=" employee_id")
	private int employeeId;
	
	@Column(name=" role_id")
	private int roleId;


	public EmployeeRole() {
	}

	public EmployeeRole(int employeeId, int roleId) {
		this.employeeId = employeeId;
		this.roleId = roleId;
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
	
	@Override
	public String toString() {
		return "EmployeeRole [employeeId=" + employeeId + ", roleId=" + roleId + "]";
	}
}
