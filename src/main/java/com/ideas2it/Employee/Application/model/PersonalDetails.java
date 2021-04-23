/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 *
 * @since 1.0
 */
package com.ideas2it.Employee.Application.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PersonalDetails class is a model class It is used to hold the user personal
 * details such as name,emailid,phonenumber It holds Address details
 * 
 * @version 1.0
 */
@Entity
@Table(name = "personal_details")
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personal_id")
	private int personalId;

	@Column(name = "name")
	private String name;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "dateof_birth")
	private String dateOfBirth;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany (mappedBy="personalDetails",
			cascade= {CascadeType.PERSIST , CascadeType.MERGE ,
					CascadeType.REFRESH } )
	private Set<Address> addressSet;


	/**
	 * Default Constructor which creates an empty object of PersonalDetails
	 */
	public PersonalDetails() {
	}

	/**
	 * Parameterized constructor with parameters of name, dateOfBirth, phoneNumber
	 * Asigning values using this keyword
	 */
	public PersonalDetails(String name, String emailId, String dateOfBirth, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}


	public void setAddressSet(Set <Address> address) { addressSet = address; }

	public Set<Address> getAddressSet() { return addressSet; }


	public int getPersonalId() {
		return personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return " \n PersonalDetails : \n  PersonalId" + getPersonalId() + "\n Name :" + getName() + "\n Phonenumber : "
				+ getPhoneNumber() + "\n EmailId : " + getEmailId() + "\n Date of birth : " + getDateOfBirth() + "" + getAddressSet().toString();
	}
}
