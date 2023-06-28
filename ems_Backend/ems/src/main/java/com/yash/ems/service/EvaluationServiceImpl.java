package com.yash.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.dao.EmployeeEvaluationDao;
import com.yash.ems.dao.EmployeeRepository;
import com.yash.ems.dao.EmployeeSkillRatingDao;
import com.yash.ems.dao.RatingMasterDao;
import com.yash.ems.dao.SkillsDao;
import com.yash.ems.model.Employee;
import com.yash.ems.model.EmployeeEvaluation;
import com.yash.ems.model.EmployeeSkillRating;
import com.yash.ems.model.RatingMaster;
import com.yash.ems.model.Skills;

@Service
public class EvaluationServiceImpl implements EvaluationService {
	
	@Autowired
	private EmployeeEvaluationDao employeeEvaluationdao;
	
	@Autowired
	private EmployeeSkillRatingDao employeeSkillRatingdao;
	
	@Autowired
	private RatingMasterDao retingMasterdao;
	
	@Autowired
	private SkillsDao skillsdao;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	

	@Override
	public List<Skills> getAllSkill() {
		return skillsdao.findAll();
	}

	@Override
	public List<RatingMaster> getAllRatingMaster() {
		return retingMasterdao.findAll();
	}

	@Override
	public EmployeeEvaluation saveEmployeeEvaluation(EmployeeEvaluation empEvaluation) {
		// TODO Auto-generated method stub
		return this.employeeEvaluationdao.save(empEvaluation);
	}

	@Override
	public List<EmployeeSkillRating> saveEmpSkillRating(List<EmployeeSkillRating> empSkillRatingList) {
		// TODO Auto-generated method stub
		return this.employeeSkillRatingdao.saveAll(empSkillRatingList);
	}

	@Override
	public List<String> getAllEmployeeIds() {
		// TODO Auto-generated method stub
		List<Employee> empList = this.employeeRepo.findAll();
		
		List<String> resourceIdList  = empList
	            .stream().map(emp2 -> String.valueOf(emp2.getYashEmpId())).collect(Collectors.toList());
		
		return resourceIdList;
	}

	@Override
	public Employee getEmployeeByYashId(long yashId) {
		// TODO Auto-generated method stub
		Employee emp = this.employeeRepo.findEmployeeByYashId(yashId);
		return emp;
	}

	
}
