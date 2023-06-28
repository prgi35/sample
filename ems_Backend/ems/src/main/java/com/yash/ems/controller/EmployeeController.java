package com.yash.ems.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Employee;
import com.yash.ems.model.EmployeeEvaluation;
import com.yash.ems.model.EmployeeSkillRating;
import com.yash.ems.model.RatingMaster;
import com.yash.ems.model.Skills;
import com.yash.ems.service.EmployeeService;
import com.yash.ems.service.EvaluationService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EvaluationService evaluationService;
	
	// add Employee
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee saveEmployeeDetails = employeeService.saveEmployeeDetails(employee);
		return ResponseEntity.ok(saveEmployeeDetails);
	}

	// get All Employee
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> allEmployeeDetails = employeeService.getAllEmployeeDetails();
		return ResponseEntity.ok(allEmployeeDetails);
	}

	// get single Employee by Id
	@GetMapping("/getEmp/{employeeId}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable int employeeId) {

		Employee singleEmployeeDetails = employeeService.getSingleEmployeeDetails(employeeId);
		return ResponseEntity.ok(singleEmployeeDetails);
	}

	// update Employee
	@PutMapping("/updateEmp/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
		Employee updateEmployeeDetails = employeeService.updateEmployeeDetails(employeeId, employee);
		return ResponseEntity.ok(updateEmployeeDetails);
	}

	// delete Employee
	@DeleteMapping("/deleteEmp/{employeeId}")
	public ResponseEntity<Map<String, Integer>> deleteEmployee(@PathVariable int employeeId) {
		int deleteEmp = employeeService.deleteEmployeeDetails(employeeId);
		Map<String, Integer> map = new HashMap<>();
		map.put("Employee Deleted with id :", deleteEmp);
		return ResponseEntity.ok(map);
	}
	

	@GetMapping("skill")
	public ResponseEntity<?> getAllSkill(){
		System.out.println("Find All");
		List<Skills>skillList=evaluationService.getAllSkill();
		return ResponseEntity.ok().body(skillList);
	}
	
	
	@GetMapping("rating")
	public ResponseEntity<?> getAllRating()
	{
		List<RatingMaster> ratingList=evaluationService.getAllRatingMaster();
		return ResponseEntity.ok().body(ratingList);
	}

	
	@PostMapping("/saveEmployee")
	public EmployeeEvaluation saveEmployeeEvaluation(@RequestBody EmployeeEvaluation empEvaluation,
			@RequestParam String[] skillRatingList) {
		EmployeeEvaluation empEvalution = null;
		List<EmployeeSkillRating> skillRatingData = new ArrayList<>();
		EmployeeSkillRating empSkillRating = null;
		Skills skill = null;
		RatingMaster ratingMaster = null;
		Employee emp = new Employee();
		//Employee emp2 = evaluationService.getEmployeeByYashId(empEvaluation.getYashEmployeeId());
		Employee emp2 = evaluationService.getEmployeeByYashId(empEvaluation.getEmpEvaluationId());
		
      try {
    	  emp.setYashEmpId(emp2.getYashEmpId());
  		  emp.setEmployeeId(emp2.getEmployeeId());
  		  empEvaluation.setEmployee(emp);
		  empEvalution = evaluationService.saveEmployeeEvaluation(empEvaluation);
      }catch (EntityNotFoundException e) {
		// TODO: handle exception
    	  e.printStackTrace();
    	  return null;
	}catch (NullPointerException e1) {
		// TODO: handle exception
		e1.printStackTrace();
		 return null;
	}

		for (String skillOrRating : skillRatingList) {
			empSkillRating = new EmployeeSkillRating();
			empSkillRating.setEmpEvaluation(empEvalution);
			
			String[] skillRating = skillOrRating.split("_");
			skill = new Skills();
			skill.setSkill_id(Long.parseLong(skillRating[0]));
			
			ratingMaster = new RatingMaster();
			ratingMaster.setRatingId(Long.parseLong(skillRating[1]));
			
			empSkillRating.setSkills(skill);
			empSkillRating.setRatingMaster(ratingMaster);
			//evaluationService.saveEmpSkillRating(empSkillRating);
			skillRatingData.add(empSkillRating);
		}
		evaluationService.saveEmpSkillRating(skillRatingData);
		return empEvaluation;
	}
	
	
	  @GetMapping("/resourceIdList") 
	  public ResponseEntity<?> getAllResourceId() {
		  
	  List<String> resourceIdList = evaluationService.getAllEmployeeIds();
	  return ResponseEntity.ok().body(resourceIdList); 
	  
	  }
	 
}
