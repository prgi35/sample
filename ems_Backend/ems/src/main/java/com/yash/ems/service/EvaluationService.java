package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.Employee;
import com.yash.ems.model.EmployeeEvaluation;
import com.yash.ems.model.EmployeeSkillRating;
import com.yash.ems.model.RatingMaster;
import com.yash.ems.model.Skills;

public interface EvaluationService {

	public List<Skills> getAllSkill();

	public List<RatingMaster> getAllRatingMaster();

	public EmployeeEvaluation saveEmployeeEvaluation(EmployeeEvaluation empEvaluation);

	public List<EmployeeSkillRating> saveEmpSkillRating(List<EmployeeSkillRating> empSkillRatingList);

	public List<String> getAllEmployeeIds();
	
	public Employee getEmployeeByYashId(long yashId);
}
