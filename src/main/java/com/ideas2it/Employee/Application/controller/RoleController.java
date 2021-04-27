package com.ideas2it.Employee.Application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.Employee.Application.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping({ "/RolesController/Insert", "/RolesController/Update", "/RolesController/Delete", 
	"/RolesController/View" }) 
	public String addRole() {
		return "AddRole";
	} 
	
	@RequestMapping("/RolesController/Insert/submit")  
	public String insertEmployee(@RequestParam Map<String, String> allRequestParam, Model model) {
		System.out.println(allRequestParam);
		String roleName = allRequestParam.get("RoleName");
		int employeeId = Integer.parseInt(allRequestParam.get("EmployeeId")); 
		String status = roleService.insertRole(employeeId, roleName);
		model.addAttribute("status", status); 
		return "EmployeeSubmission";
	}
}
