package com.yash.ems.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.dao.EmployeeRepository;
import com.yash.ems.exception.ResourceNotFoundException;
import com.yash.ems.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	// add Employee Details
	public Employee saveEmployeeDetails(Employee employee) {
		return this.employeeRepo.save(employee);
	}

	// Get Employee all Details
	public List<Employee> getAllEmployeeDetails() {
		return this.employeeRepo.findAll();
	}

	// get single Employee Details By Id
	public Employee getSingleEmployeeDetails(int employeeId) {
		return this.employeeRepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this employee Id" + employeeId));
	}

	// update Employee Details
	public Employee updateEmployeeDetails(int employeeId, Employee employee) {
		Employee employee1 = employeeRepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this employee Id" + employeeId));
		employee1.setEmployeeName(employee.getEmployeeName());
		employee1.setGrade(employee.getGrade());
		employee1.setDesignation(employee.getDesignation());
		employee1.setEmail(employee.getEmail());
		employee1.setDateOfJoining(employee.getDateOfJoining());
		employee1.setBaseLocation(employee.getBaseLocation());
		employee1.setCurrentLocation(employee.getCurrentLocation());
		employee1.setPrimarySkills(employee.getPrimarySkills());
		employee1.setSecondarySkills(employee.getSecondarySkills());
		employee1.setExprience(employee.getExprience());
		employee1.setMobileNo(employee.getMobileNo());
		employee1.setIrm(employee.getIrm());

		employeeRepo.save(employee1);
		return employee1;
	}

	// Delete Employee
	public int deleteEmployeeDetails(int employeeId) {

		Employee employee = employeeRepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this employee Id" + employeeId));
		int empId2 = employee.getEmployeeId();
		employeeRepo.delete(employee);
		return empId2;
	}
	
}
