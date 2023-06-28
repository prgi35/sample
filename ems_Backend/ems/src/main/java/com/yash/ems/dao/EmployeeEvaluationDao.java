package com.yash.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.yash.ems.model.EmployeeEvaluation;

public interface EmployeeEvaluationDao extends JpaRepository<EmployeeEvaluation, Long>{

	//public EmployeeEvaluation save(EmployeeEvaluation empEvaluation);
	
	

}
