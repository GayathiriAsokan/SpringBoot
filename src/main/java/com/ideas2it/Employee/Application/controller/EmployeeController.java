/**
 * Provide necessary to create a url mappping  in controller
 */
package com.ideas2it.Employee.Application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.ideas2it.Employee.Application.model.Address;
import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.Role;
import com.ideas2it.Employee.Application.service.EmployeeService;
import com.ideas2it.Employee.Application.model.EmployeeRole;


/**
 * @description AddEmployee is used to add employee values 
 * @author GAYATHIRI
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * AddEmployee method is used to add employee details 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	 @GetMapping(value = "/") 
	public String Index() {
		return "Index";
	}

	/**
	 * AddEmployee method is used to add employee details 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping({ "/EmployeeController/Insert", "/EmployeeController/Update", "/EmployeeController/Delete", 
	"/EmployeeController/View" })  
	public String addEmployee() {
		return "AddEmployee";
	}


	/**
	 * InsertEmployee method is used to add employee details 
	 */
	@RequestMapping("/EmployeeController/Insert/submit")  
	public String insertEmployee(@RequestParam Map<String, String> requestParam, Model model) {
		System.out.println(requestParam);
		String companyName = requestParam.get("CompanyName"); 
		double salary = Double.parseDouble(requestParam.get("Salary")); 
		String designation = requestParam.get("Designation"); 
		int experience = Integer.parseInt(requestParam.get("Experience")); 
		String status =		requestParam.get("Status"); String name = requestParam.get("Name");
		long phoneNumber = Long.parseLong(requestParam.get("PhoneNumber")); 
		String emailId = requestParam.get("EmailId");
		String dateOfBirth = requestParam.get("DateOfBirth");
		HashMap <String, Object>	currentAddressMap = new HashMap <String, Object>();
		currentAddressMap.put("Street", requestParam.get("Street"));
		currentAddressMap.put("City", requestParam.get("City"));
		currentAddressMap.put("District", requestParam.get("District"));
		currentAddressMap.put("PinCode",
				Integer.parseInt(requestParam.get("PinCode")));
		currentAddressMap.put("State", requestParam.get("State"));
		currentAddressMap.put("AddressType", requestParam.get("AddressType"));
		HashMap <String, Object> permanentAddressMap = new HashMap <String, Object>();
		permanentAddressMap.put("Street",  requestParam.get("PermanentStreet"));
		permanentAddressMap.put("City",  requestParam.get("PermanentCity"));
		permanentAddressMap.put("District",  requestParam.get("PermanentDistrict"));
		permanentAddressMap.put("PinCode", Integer.parseInt(requestParam.get("PermanentPinCode")));  
		permanentAddressMap.put("State", requestParam.get("PermanentState"));
		permanentAddressMap.put("AddressType", requestParam.get("PermanentAddressType")); 
		employeeService.insertEmployee(companyName, salary, designation, experience,
				status, name, phoneNumber, dateOfBirth, emailId, currentAddressMap,
				permanentAddressMap);
		model.addAttribute("status", "INSERTED SUCESSFULLY"); 
		return "EmployeeSubmission";
	}

	/**
	 * Display the details of employee for update,delete and view 
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws EmployeeIdNotExist 
	 */
	@RequestMapping("/EmployeeController/Update/ajax")  
	@ResponseBody
	public String viewEmployee(@RequestParam String EmployeeId)  {
		int employeeId = Integer.parseInt(EmployeeId);
		JSONArray arrayEmployeeValues = new JSONArray();
		employeeService.getEmployee(employeeId);
		System.out.println();
		JSONObject employee = new JSONObject();
		employee.put("companyName", employeeService.getEmployee(employeeId).getCompanyName());
		employee.put("salary", employeeService.getEmployee(employeeId).getSalary());
		employee.put("designation", employeeService.getEmployee(employeeId).getDesignation());
		employee.put("experience", employeeService.getEmployee(employeeId).getExperience());
		employee.put("status", employeeService.getEmployee(employeeId).getStatus());
		employee.put("name",employeeService.getEmployee(employeeId).getPersonalDetails().getName());
		employee.put("phoneNumber",
				employeeService.getEmployee(employeeId).getPersonalDetails().getPhoneNumber());
		employee.put("emailId",
				employeeService.getEmployee(employeeId).getPersonalDetails().getEmailId());
		String dateString =
				employeeService.getEmployee(employeeId).getPersonalDetails().getDateOfBirth()
				.replace("/", "-"); 
		employee.put("dateOfBirth", dateString); 
		List <Address> addressList = new ArrayList <Address>
		(employeeService.getEmployee(employeeId).getPersonalDetails().getAddressSet()); 
		employee.put("currentStreet",addressList.get(0).getStreet());
		employee.put("currentCity",addressList.get(0).getCity());
		employee.put("currentDistrict",addressList.get(0).getDistrict());
		employee.put("currentState",addressList.get(0).getState());
		employee.put("currentPinCode",addressList.get(0).getPinCode());
		employee.put("currentAddressType",addressList.get(0).getAddressType());
		employee.put("permanentStreet",addressList.get(1).getStreet());
		employee.put("permanentCity",addressList.get(1).getCity());
		employee.put("permanentDistrict",addressList.get(1).getDistrict());
		employee.put("permanentState",addressList.get(1).getState());
		employee.put("permanentPinCode",addressList.get(1).getPinCode());
		employee.put("permanentAddressType",addressList.get(1).getAddressType());
		System.out.println(employee);
		arrayEmployeeValues.put(employee);
		return arrayEmployeeValues.toString();
	}

	/**
	 * UpdateEmployee method is used to update the employee details
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/Update/submit")  
	public String updateEmployee(@RequestParam Map<String, String> requestParam, Model model) {
		int employeeId = Integer.parseInt(requestParam.get("EmployeeId")); 
		long phoneNumber = Long.parseLong(requestParam.get("PhoneNumber"));
		String emailId = requestParam.get("EmailId");
		String status = employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId);
		model.addAttribute("status", status);
		System.out.println(status);
		return "EmployeeSubmission";
	}

	/**
	 * DeleteEmployee is used to change the status of the employee
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/Delete/submit")  
	public String deleteEmployee(@RequestParam Map<String, String> requestParam, Model model) {
		int employeeId = Integer.parseInt(requestParam.get("EmployeeId")); 
		String status = employeeService.deleteEmployee(employeeId);
		model.addAttribute("status", status);
		System.out.println(status);
		return "EmployeeSubmission";
	}

	/**
	 * Display the details of the employee
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/ViewAll")  
	public String displayEmployee(Model model) {
		List<Employee> employees = employeeService.getAllEmployee();
		model.addAttribute("employees", employees); 
		return "ViewAllEmployee";
	}
	
	/**
	 * InsertEmployeeToProject method is used to add project to employee
	 */
	@RequestMapping("/EmployeeController/AddRole")  
	public String insertEmployeeToProject(Model model) {
		List<Integer> employees = employeeService.findAll();
		model.addAttribute("employeeById", employees.get(1));
		model.addAttribute("rolesById", employees.get(0));
		return "EmployeeRole";
	}
	
	/** AddEmployeeToProject is used to add employee and project Details
	 * To insert and view the employee and project
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/AddRole/submit")
	public String addEmployeeToProject(@RequestParam  Map<String,String> requestParam, Model model) {
		System.out.println(requestParam);
		String employeeId = requestParam.get("employee");
		String roleId =  requestParam.get("roles");
		System.out.println(employeeId + "" + roleId);
		String status = employeeService.addProjectEmployee(employeeId, roleId);
		/*
		 * List <Integer> listProjectId = new ArrayList <Integer> (); int employeeId =
		 * Integer.parseInt(requestParam.get("Employee")); String [] project =
		 * requestParam.get("Project"); for (int index = 0; index < project.length
		 * ;index ++) { System.out.println(project[index]);
		 * listProjectId.add(Integer.parseInt(project[index])); }
		 * System.out.println(listProjectId); String status =
		 * employeeService.addProjectEmployee(listProjectId, employeeId);
		 * model.addAttribute("status", status); System.out.println(status);
		 */
		 model.addAttribute("status", status);
		return "EmployeeSubmission";
	}
}