package com.example.demo.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@Column(name="role_status")
	private String roleStatus;
	
	/*
	 * @ManyToMany( mappedBy = "roles") private List<User> user;
	 */
	
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
	public Role( String roleName, String roleStatus) {
		this.roleName = roleName;
		this.roleStatus = roleStatus;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setgetRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
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
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleStatus=" + roleStatus + "]";
	}
}
