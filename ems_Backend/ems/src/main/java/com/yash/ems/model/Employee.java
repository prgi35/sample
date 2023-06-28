package com.yash.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "yash_emp_Id")
    private long yashEmpId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "grade")
	private String grade;

	@Column(name = "designation")
	private String designation;

	@Column(name = "email")
	private String email;

	@Column(name = "date_of_joining")
	private String dateOfJoining;

	@Column(name = "base_location")
	private String baseLocation;

	@Column(name = "current_location")
	private String currentLocation;

	@Column(name = "primary_skills")
	private String primarySkills;

	@Column(name = "secondary_skills")
	private String secondarySkills;

	@Column(name = "exprience")
	private String exprience;

	@Column(name = "mobile_no")
	private long mobileNo;

	@Column(name = "irm")
	private String irm;

	// Default Constructor
	public Employee() {

	}

	// Parameterized Construction
	public Employee(int employeeId, String employeeName, String grade, String designation, String email,
			String dateOfJoining, String baseLocation, String currentLocation, String primarySkills,
			String secondarySkills, String exprience, long mobileNo, String irm, long yashEmpId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.grade = grade;
		this.designation = designation;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.exprience = exprience;
		this.mobileNo = mobileNo;
		this.irm = irm;
		this.yashEmpId = yashEmpId;
	}

	// Getters and setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public String getExprience() {
		return exprience;
	}

	public void setExprience(String exprience) {
		this.exprience = exprience;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIrm() {
		return irm;
	}

	public void setIrm(String irm) {
		this.irm = irm;
	}

	public long getYashEmpId() {
		return yashEmpId;
	}

	public void setYashEmpId(long yashEmpId) {
		this.yashEmpId = yashEmpId;
	}
	
	

	
}
