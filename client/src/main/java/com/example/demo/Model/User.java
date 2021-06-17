/**
 * Provide neccessary to create user class to interact with user service 
 */
package com.example.demo.Model;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

/**
 * Users is  used to create  a role  for roles 
 * @author GAYATHIRI
 *
 */
@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="user_name")
	private String username;

	@Column(name="designation")
	private String designation ;

	@Column(name="password ")
	private String password ;

	@Column(name="experience")
	private int experience;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "user_role", 
			joinColumns = { @JoinColumn(name = "user_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id") }
			)
	private  Set<Role> role;

	public User() {
	}

	public User(String userId, String designation, int experience, String password,String username) {
		super();
		this.userId = userId;
		this.designation = designation;
		this.experience = experience;
		this.password = password;
		this.username = username;
	}

	/**
	 * Getters and setters for Role
	 */


	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public Set<Role> getRole() {
		return role;
	}

	public String getDesignation() {
		return designation;
	}

	public int getExperience() {
		return experience;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", designation=" + designation + ", experience=" + experience + ", role="
				+ role + "]";
	}


}
