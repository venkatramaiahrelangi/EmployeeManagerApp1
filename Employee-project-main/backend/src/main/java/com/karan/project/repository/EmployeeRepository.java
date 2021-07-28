package com.karan.project.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.project.modal.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
