package com.yash.ems.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="employee_evaluation")
public class EmployeeEvaluation {
	
	@Id
	@Column(name = "emp_evaluation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empEvaluationId;
	
	@Column(name = "evaluation_date")
	private Date evaluationDate;

	@Column(name = "evaluation_number")
	private long evaluationNumber;
	
	@Column(name = "evaluated_by")
	private String evaluatedBy;
	
	@Column(name = "overall_rating")
	private long overallRating;
	
	@Column(name = "remarks")
	private String remarks;
	
	@OneToOne
	@JoinColumn(name="employee_id")
	public Employee employee;
	
	@Transient
	private long yashEmployeeId;
	
	

	public long getYashEmployeeId() {
		return yashEmployeeId;
	}

	public void setYashEmployeeId(long yashEmployeeId) {
		this.yashEmployeeId = yashEmployeeId;
	}

	public long getEmpEvaluationId() {
		return empEvaluationId;
	}

	public void setEmpEvaluationId(long empEvaluationId) {
		this.empEvaluationId = empEvaluationId;
	}

	public Date getEvaluationDate() {
		return evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public long getEvaluationNumber() {
		return evaluationNumber;
	}

	public void setEvaluationNumber(long evaluationNumber) {
		this.evaluationNumber = evaluationNumber;
	}

	public String getEvaluatedBy() {
		return evaluatedBy;
	}

	public void setEvaluatedBy(String evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
	}

	public long getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(long overallRating) {
		this.overallRating = overallRating;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	

}
