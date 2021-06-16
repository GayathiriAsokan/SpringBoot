/**
 * Provide neccessary to create role class to interact with role service 
 */
package com.example.demo.Model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.Model.UserDetails;
/**
 * Role is  used to create  a role  for users
 * @author GAYATHIRI
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

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL },mappedBy = "role")
	private Set<UserDetails> user;


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

	/**
	 * Getters and setters for Role
	 */

	public String getRoleStatus() {
		return roleStatus;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setgetRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Set<UserDetails> getUser() {
		return user;
	}

	public void setUser(Set<UserDetails> user) {
		this.user = user;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleStatus=" + roleStatus + "]";
	}
}
