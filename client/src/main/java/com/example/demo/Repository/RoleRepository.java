package com.example.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Role;

/**
 * This interface is used to interact with database using jpa repository
 * 
 * @author GAYATHIRI
 *
 */
public interface RoleRepository extends CrudRepository<Role , Integer>{

	@Query(value="select count(role_id) from role where role.role_id = ?1",  nativeQuery=true) 
	Long countRole(int roleId);

}
