package com.yash.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
//    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "user_id")
    private int id;

	@Column(name = "user_name")
    private String name;

    private String email;
    
    private String role;
    
    private String password;
    
    @Column(name = "conform_password")
    private String confirmPassword;
    
    @Transient
    private String authStatus;
    
    @Transient
    private String authErrorMsg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getAuthErrorMsg() {
		return authErrorMsg;
	}

	public void setAuthErrorMsg(String authErrorMsg) {
		this.authErrorMsg = authErrorMsg;
	}
    

	
	
    
}
