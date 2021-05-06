package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Constants;
import com.example.demo.Model.Role;
import com.example.demo.Service.RoleService;
import com.example.demo.Repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository  roleRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String insertRole(Role role) {
			roleRepository.save(role);
			return  Constants.INSERT_MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String updateRole(Role role) {
			roleRepository.save(role);
			return Constants.UPDATE_MESSAGE;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteRole(int roleId) {
		roleRepository.deleteById(roleId);
		return Constants.DELETE_MESSAGE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role getRole(int roleId) {
		Optional<Role> role = this.roleRepository.findById(roleId);
		return role.get(); 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List <Role> getAllRole() {
		List <Role> roles = new ArrayList<Role> ();
		 roleRepository.findAll().forEach(roles :: add);
		 return roles;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int count() {
		return (int) roleRepository.count();
	}
}
