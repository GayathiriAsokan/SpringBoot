package com.ideas2it.Employee.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideas2it.Employee.Application.model.Role;

public interface RoleRepository extends JpaRepository<Role , Integer>{
	
	/*
	 * @Query("SELECT COUNT(*) FROM Role") int roleCount();
	 */

}
