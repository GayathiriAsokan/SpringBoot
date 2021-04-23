/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
package com.ideas2it.Employee.Application.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ideas2it.Employee.Application.model.Address;
import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.PersonalDetails;
import com.ideas2it.Employee.Application.repository.EmployeeRepository;
import com.ideas2it.Employee.Application.service.EmployeeService;

/**
 * @description EmployeeService used to hold PersonalDetails,Address,Employee
 * We can view, remove, add, update operations in employee data
 * Meanwhile validating employee data
 * @author GAYATHIRI
 * @version 1.2
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee insertEmployee(String companyName, double salary, String designation, int experience, String status,
			String name, long phoneNumber, String dateOfBirth, String emailId, HashMap <String, Object> currentAddressMap , HashMap <String, Object> permanentAddressMap) {
		String mobileNumber = Long.toString(phoneNumber);
		String insertStatus = "";
		PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, mobileNumber);
		Address currentAddress = addAddressValues(currentAddressMap);
		Address permanentAddress = addAddressValues(permanentAddressMap);
		Set <Address> address = new HashSet <Address> ();
		address.add(currentAddress);
		address.add(permanentAddress);
		personalDetails.setAddressSet(address);
		Employee employee = new Employee(companyName, salary, experience, designation, status);
		employee.setPersonalDetails(personalDetails);
		currentAddress.setPersonalDetails(personalDetails); 
		permanentAddress.setPersonalDetails(personalDetails);
		return employeeRepository.save(employee);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee getEmployee(int employeeId) {
		Optional<Employee> employee = this.employeeRepository.findById(employeeId);
		return employee.get(); 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteEmployee(int employeeId) {
		Optional<Employee> employees = this.employeeRepository.findById(employeeId);
		Employee employee = employees.get();
		employee.setStatus("INACTIVE");
		employeeRepository.save(employee);
		return "DELETED SUCCESSFULLY";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address addAddressValues(HashMap <String, Object> employeeMap) {
		String street = (String) employeeMap.get("Street");
		String city = (String) employeeMap.get("City");
		String district = (String) employeeMap.get("District");
		String state = (String) employeeMap.get("State");
		String addressType = (String) employeeMap.get("AddressType");
		int pinCode = (int) employeeMap.get("PinCode");
		Address addressValues = new Address(street, city, district, pinCode, state, addressType);
		return addressValues;
	}

	/**
	 * {@inheritDoc}
	 *
	@Override
	public List<Integer> validateEmployeeData(long phoneNumber, String emailId) {
		return employeeDAO.isDuplicate(phoneNumber, emailId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		Optional<Employee> employees = this.employeeRepository.findById(employeeId);
		Employee employee = employees.get();
		employee.getPersonalDetails().setPhoneNumber(Long.toString(phoneNumber));
		employee.getPersonalDetails().setEmailId(emailId);
		employeeRepository.save(employee);
		return "UPDATED SUCCESSFULLY";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String addProjectEmployee(List <Integer> listId, int employeeId) {
		//employeeDAO.addProjectEmployee(listId, employeeId);
		return "success";
	}
}

