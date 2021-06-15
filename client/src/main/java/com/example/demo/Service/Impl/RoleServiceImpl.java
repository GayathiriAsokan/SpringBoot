package com.example.demo.Service.Impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

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

	@Autowired
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role insertRole(Role role) {
		return roleRepository.save(role);
		//return  Constants.INSERT_MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
		//return Constants.UPDATE_MESSAGE;
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
	public Long count(int roleId) {
		Long id = 0l;
		try {
			id = roleRepository.countUser(roleId);
			if (null != id &&  id != 0) {
				return  id;
			}
		}  catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return  id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role userRoles(Role role) {
		return roleRepository.save(role);
		//return "Inserted success";
	}
}
