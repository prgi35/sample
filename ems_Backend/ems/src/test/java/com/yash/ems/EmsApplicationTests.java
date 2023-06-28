package com.yash.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ems.dao.EmployeeRepository;
import com.yash.ems.model.Employee;

@SpringBootTest
@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class EmsApplicationTests {

	@Autowired
	EmployeeRepository empRepo;

	// add Employee Data
	@Test
	@Order(1)
	public void testAddEmpData() {
		Employee emp = new Employee();
		emp.setEmployeeName("amit");
		emp.setGrade("T2");
		emp.setDesignation("software engineer");
		emp.setEmail("amit@yash.com");
		emp.setDateOfJoining("10th dec 2020");
		emp.setBaseLocation("hydrabad");
		emp.setCurrentLocation("pune");
		emp.setPrimarySkills("python");
		emp.setSecondarySkills("pycharm framework");
		emp.setExprience("3 years");
		emp.setMobileNo(705701168);
		emp.setIrm("snehal");
		empRepo.save(emp);
		assertNotNull(empRepo.findById(3).get());
	}

	// get All Employee Data
	@Test
	@Order(2)
	public void testGetAllEmp() {
		List<Employee> list = empRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	// get Single Employee Data
	@Test
	@Order(3)
	public void testGetEmp() {
		Employee emp = empRepo.findById(2).get();
		assertEquals("akshay", emp.getEmployeeName());
	}

	// update Employee Data
	@Test
	@Order(4)
	public void updateEmp() {
		Employee e = empRepo.findById(2).get();
		e.setGrade("T3");
		empRepo.save(e);
		assertNotEquals("T1", empRepo.findById(2).get().getGrade());
	}

	// delete Employee Data
	@Test
	@Order(5)
	public void testDeleteEmp() {
		empRepo.deleteById(3);
		assertThat(empRepo.existsById(3)).isFalse();
	}

}
