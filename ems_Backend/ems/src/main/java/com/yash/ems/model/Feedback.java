package com.yash.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "feedback_details")
public class Feedback {
	
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedback_id;
	 
	@Column(name ="project_name")
	private String project_name;
	
	@Column(name ="client_name")
	private String client_name;
	
	@Column(name ="project_manager")
	private String project_manager;
	
	@Column(name = "reason_for_release")
	private String reason_for_release;
	
	@Column(name="technical_knowledge_rating")
	private long technical_knowledge_rating;
	
	@Column(name ="work_quality_rating")
	private long work_quality_rating;
	
	@Column(name = "communication_rating")
	private long communication_rating;
	
	@Column(name="team_playing_rating")
	private long team_playing_rating;
	
	@Column(name="overall_rating")
	private long overall_rating;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column
	private int employee_id;

	public int getFeedback_id() { 
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getProject_manager() {
		return project_manager;
	}

	public void setProject_manager(String project_manager) {
		this.project_manager = project_manager;
	}

	public String getReason_for_release() {
		return reason_for_release;
	}

	public void setReason_for_release(String reason_for_release) {
		this.reason_for_release = reason_for_release;
	}

	public long getTechnical_knowledge_rating() {
		return technical_knowledge_rating;
	}

	public void setTechnical_knowledge_rating(long technical_knowledge_rating) {
		this.technical_knowledge_rating = technical_knowledge_rating;
	}

	public long getWork_quality_rating() {
		return work_quality_rating;
	}

	public void setWork_quality_rating(long work_quality_rating) {
		this.work_quality_rating = work_quality_rating;
	}

	public long getCommunication_rating() {
		return communication_rating;
	}

	public void setCommunication_rating(long communication_rating) {
		this.communication_rating = communication_rating;
	}

	public long getTeam_playing_rating() {
		return team_playing_rating;
	}

	public void setTeam_playing_rating(long team_playing_rating) {
		this.team_playing_rating = team_playing_rating;
	}

	public long getOverall_rating() {
		return overall_rating;
	}

	public void setOverall_rating(long overall_rating) {
		this.overall_rating = overall_rating;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Feedback(int feedback_id, String project_name, String client_name, String project_manager,
			String reason_for_release, long technical_knowledge_rating, long work_quality_rating,
			long communication_rating, long team_playing_rating, long overall_rating, String remarks, int employee_id) {
		super();
		this.feedback_id = feedback_id;
		this.project_name = project_name;
		this.client_name = client_name;
		this.project_manager = project_manager;
		this.reason_for_release = reason_for_release;
		this.technical_knowledge_rating = technical_knowledge_rating;
		this.work_quality_rating = work_quality_rating;
		this.communication_rating = communication_rating;
		this.team_playing_rating = team_playing_rating;
		this.overall_rating = overall_rating;
		this.remarks = remarks;
		this.employee_id = employee_id;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Feedback [feedback_id=" + feedback_id + ", project_name=" + project_name + ", client_name="
				+ client_name + ", project_manager=" + project_manager + ", reason_for_release=" + reason_for_release
				+ ", technical_knowledge_rating=" + technical_knowledge_rating + ", work_quality_rating="
				+ work_quality_rating + ", communication_rating=" + communication_rating + ", team_playing_rating="
				+ team_playing_rating + ", overall_rating=" + overall_rating + ", remarks=" + remarks + ", employee_id="
				+ employee_id + "]";
	}
	
	
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
