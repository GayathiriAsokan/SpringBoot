package com.ideas2it.Employee.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.Employee.Application.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

}
