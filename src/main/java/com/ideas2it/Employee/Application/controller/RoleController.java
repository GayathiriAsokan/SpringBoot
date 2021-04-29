/**
 *  Provide necessary to create a url mappping  in controller
 */
package com.ideas2it.Employee.Application.controller;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideas2it.Employee.Application.model.Role;
import com.ideas2it.Employee.Application.service.RoleService;

/**
 * Role  Controller is used to create map  the url 
 * To call service class
 * @author ubuntu
 *
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * Add Role is used to create role details 
	 * @return
	 */
	@RequestMapping({ "/RolesController/Insert", "/RolesController/Update", "/RolesController/Delete", 
	"/RolesController/View" }) 
	public String addRole() {
		return "AddRole";
	} 

	/**
	 * To add  the values in role  
	 * @param allRequestParam
	 * @param model
	 * @return
	 */
	@RequestMapping("/RolesController/Insert/submit")  
	public String insertRole(@RequestParam Map<String, String> requestParam, Model model) {
		String roleName = requestParam.get("RoleName");
		int employeeId = Integer.parseInt(requestParam.get("EmployeeId")); 
		String status = roleService.insertRole(employeeId, roleName);
		model.addAttribute("status", status); 
		return "EmployeeSubmission";
	}

	/**
	 * To view roles and send json values 
	 * @param RoleId
	 * @return
	 */
	@RequestMapping("/RolesController/Update/ajax")
	@ResponseBody
	public String viewRole(@RequestParam String RoleId) {
		int roleId = Integer.parseInt(RoleId);
		JSONArray arrayEmployeeValues = new JSONArray();
		JSONObject role = new JSONObject();
		role.put("employeeId", roleService.getRole(roleId).getEmployeeId());
		role.put("roleName", roleService.getRole(roleId).getRoleName());
		arrayEmployeeValues.put(role);
		return arrayEmployeeValues.toString();
	}

	/**
	 * To update the role details in Role   
	 * @param requestParam
	 * @param model
	 * @return
	 */
	@RequestMapping("/RolesController/Update/submit")  
	public String updateRole(@RequestParam Map<String, String> requestParam, Model model) {
		int employeeId = Integer.parseInt(requestParam.get("EmployeeId")); 
		int roleId = Integer.parseInt(requestParam.get("RoleId")); 
		String status = roleService.updateRole(employeeId, roleId);
		model.addAttribute("status", status); 
		return "EmployeeSubmission";
	}


	/**
	 * 
	 */
	@RequestMapping("/RolesController/ViewAllProject")
	public String viewAll(Model model) {
		List<Role> roles = roleService.getAllRole();
		model.addAttribute("roles", roles); 
		//System.out.println();
		return "ViewRoles";
	}
}
