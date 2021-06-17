/**
 * Provide the class necessary to create a service class
 * To communicate with controller and model classes
 *
 * @version 1.1
 * @since 1.0
 */
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
import com.example.demo.Model.User;
import com.example.demo.Service.RoleService;
import com.example.demo.Repository.RoleRepository;

/**
 * RoleServiceImpl is used to do crud operations in service 
 * @author GAYATHIRI
 *
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository  roleRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role insertRole(Role role) {
		try {
			return roleRepository.save(role);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role updateRole(Role role) {
		try {
			return roleRepository.save(role);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String deleteRole(int roleId) {
		try {
			roleRepository.deleteById(roleId);
			return Constants.DELETE_MESSAGE;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role getRole(int roleId) {
		try {
			Optional<Role> role = roleRepository.findById(roleId);
			return role.get(); 
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List <Role> getAllRole() {
		try {
			List <Role> roles = new ArrayList<Role> ();
			roleRepository.findAll().forEach(roles :: add);
			return roles;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count(int roleId) {
		Long id = 0l;
		try {
			id = roleRepository.countRole(roleId);
			if (null != id &&  id != 0) {
				return  id;
			}
		}  catch (RuntimeException e) {
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
		try {
			return roleRepository.save(role);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
