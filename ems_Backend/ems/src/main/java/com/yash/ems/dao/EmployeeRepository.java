package com.yash.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	 
	@Query("SELECT u FROM com.yash.ems.model.Employee u WHERE u.yashEmpId = ?1")
	Employee findEmployeeByYashId(long yashId);
}
