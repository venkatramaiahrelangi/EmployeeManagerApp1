package com.karan.project.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karan.project.exception.UserNotFoundException;
import com.karan.project.modal.Employee;
import com.karan.project.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepository employeeRepository; 
	
    @Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	} 
    
    public Employee addEmployee(Employee employee) {
    	employee.setEmployeeCode(UUID.randomUUID().toString());
    	return employeeRepository.save(employee);
    }
    
   public List<Employee> findAllEmployees(){
	   return employeeRepository.findAll();
	   
   }
   
   public Employee updateEmployee(Employee employee) {
	   return employeeRepository.save(employee);
   }
   
   public Employee findEmployeeById(Long id) {
	   return employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found "));
   }
   
   public void deleteEmployee(Long id) {
	   employeeRepository.deleteEmployeeById(id);
   }
}
