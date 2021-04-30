package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="designation")
	private String designation ;
	
	@Column(name="experience")
	private int experience;

	public User() {
	}
	
	public User(String userId, String designation, int experience) {
		super();
		this.userId = userId;
		this.designation = designation;
		this.experience = experience;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", designation=" + designation + ", experience=" + experience + "]";
	}
	
	
}
