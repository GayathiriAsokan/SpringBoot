package com.ideas2it.Employee.Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.Employee.Application.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee , Integer>{
	 

}
