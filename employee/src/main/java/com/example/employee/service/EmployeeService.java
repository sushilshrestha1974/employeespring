package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	//Create
	public Employee createEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	//Read	
	public List<Employee>getEmployee(){
		return empRepository.findAll();
		}
	//Delete
	public void deleteEmployee(Long empId) {
		empRepository.deleteById(empId);		
	}
	//Update
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
		Employee emp=empRepository.findById(empId).get();
		emp.setFirstName(employeeDetails.getFirstName());
		emp.setLastName(employeeDetails.getLastName());
		emp.setEmailId(employeeDetails.getEmailId());
		
		return empRepository.save(emp);
		
		
	}
}
