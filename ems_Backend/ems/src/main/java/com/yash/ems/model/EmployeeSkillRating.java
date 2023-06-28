package com.yash.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_skill_rating")

public class EmployeeSkillRating {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	@OneToOne
	@JoinColumn(name="emp_evaluation_id")
	public EmployeeEvaluation empEvaluation;
	
	@OneToOne
	@JoinColumn(name="skill_id")
	public Skills skills;
	
	@OneToOne
	@JoinColumn(name="rating_id")
	public RatingMaster ratingMaster;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public RatingMaster getRatingMaster() {
		return ratingMaster;
	}

	public void setRatingMaster(RatingMaster ratingMaster) {
		this.ratingMaster = ratingMaster;
	}

	public EmployeeEvaluation getEmpEvaluation() {
		return empEvaluation;
	}

	public void setEmpEvaluation(EmployeeEvaluation empEvaluation) {
		this.empEvaluation = empEvaluation;
	}
	
	
	
	
	



}
