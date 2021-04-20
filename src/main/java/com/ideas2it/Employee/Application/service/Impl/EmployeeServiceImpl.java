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
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ideas2it.Employee.Application.dao.Impl.EmployeeDaoImpl;
import com.ideas2it.Employee.Application.model.Address;
import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.PersonalDetails;
import com.ideas2it.Employee.Application.service.EmployeeService;
//import com.ideas2it.util.Validator;


/**
 * @description EmployeeService used to hold PersonalDetails,Address,Employee
 * We can view, remove, add, update operations in employee data
 * Meanwhile validating employee data
 * @author GAYATHIRI
 * @version 1.2
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	//Validator validator = new Validator();
	
	 @Autowired
	 private EmployeeDaoImpl employeeDAO;
	//LoggerClass logger = new LoggerClass();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String insertEmployee(String companyName, double salary, String designation, int experience, String status,
			String name, long phoneNumber, String dateOfBirth, String emailId, HashMap <String, Object> currentAddressMap , HashMap <String, Object> permanentAddressMap) {
		String mobileNumber = Long.toString(phoneNumber);
		String insertStatus = "";
		List <Integer> employeeList = validateEmployeeData(phoneNumber, emailId); 
		if (0 !=  employeeList.get(0) &&  0 != employeeList.get(1) ) {
			//logger.loggerError(Constants.DUPLICATE_ERROR_MESSAGE);
			insertStatus =  "DUPLICATE PHONE NUMBER AND EMAILID";
		} else if (employeeList.get(1) != 0) {
			//logger.loggerError(Constants.DUPLICATE_EMAILID_MESSAGE);
			insertStatus = "DUPLICATE EMAILID"; 
		} else if (employeeList.get(0) != 0) {
			//logger.loggerError(Constants.DUPLICATE_PHONENUMBER_MESSAGE);
			insertStatus = "DUPLICATE PHONE NUMBER";
		} else {
			PersonalDetails personalDetails = new PersonalDetails(name, emailId, dateOfBirth, mobileNumber);
			Address currentAddress = addAddressValues(currentAddressMap);
			Address permanentAddress = addAddressValues(permanentAddressMap);
			Set <Address> address = new HashSet <Address> ();
			address.add(currentAddress);
			address.add(permanentAddress);
			personalDetails.setAddressSet(address);
			Employee employee = new Employee(companyName, salary, experience, designation, status);
			employee.setPersonalDetails(personalDetails);
			employeeDAO.insertEmployee(employee.getSalary(), employee.getCompanyName(),
					employee.getDesignation(), employee.getExperience(), employee.getStatus(), personalDetails.getName(), personalDetails.getPhoneNumber(), personalDetails.getEmailId(), 
					personalDetails.getDateOfBirth(), currentAddress, permanentAddress);
			insertStatus = "INSERTED SUCCESSFULLY";
		}
		return insertStatus;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.viewEmployee();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee getEmployee(int employeeId) {
		return employeeDAO.employeeViewById(employeeId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
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
	 */
	@Override
	public List<Integer> validateEmployeeData(long phoneNumber, String emailId) {
		return employeeDAO.isDuplicate(phoneNumber, emailId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
		List<Integer> employeeList = new ArrayList<Integer>();
		employeeList = validateEmployeeData(phoneNumber, emailId);
		if (employeeList.get(0) == 0 && employeeList.get(1) == 0) {
			employeeDAO.updatePersonalDetails(employeeId, phoneNumber, emailId);
			return "UPDATED SUCCESSFULLY";
		} else {
			//logger.loggerError(Constants.DUPLICATE_EMPLOYEE_MESSAGE);
			return "ALREADY EXIXTS  DUPLICATE VALUE";
		}
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

