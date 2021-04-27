package com.ideas2it.Employee.Application.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.Employee.Application.model.Employee;
import com.ideas2it.Employee.Application.model.Role;
import com.ideas2it.Employee.Application.repository.EmployeeRepository;
import com.ideas2it.Employee.Application.repository.RoleRepository;
import com.ideas2it.Employee.Application.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository  roleRepository;

	@Override
	public String insertRole(int employeeId, String roleName) {
		if(isEmployeeById(employeeId)) {
			Role role = new Role(roleName, employeeId);
			roleRepository.save(role);
			return "INSERTED SUCCESSFULLY";
		} else {
			return "EmployeeId NOT EXIST";
		}
	}

	@Override
	public String updateRole(int employeeId, int projectId) {
		if(isEmployeeById(employeeId)) {
			Optional<Role> employees = this.roleRepository.findById(employeeId);
			Role role = employees.get();
			role.setEmployeeId(employeeId);
			roleRepository.save(role);
			return "UPDATED SUCCESSFULY";
		} else {
			return "EmployeeId NOT EXIST";
		}
	}

	public boolean isEmployeeById(int employeeId) {
		if (employeeRepository.existsById(employeeId)) {
			return true;
		} else {
			return false;
		}
	}
}
