package com.yash.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rating_master")
public class RatingMaster {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long ratingId;
	
	@Column(name = "rating_label")
	 private String ratingLabel;

	public RatingMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingMaster(long ratingId, String ratingLabel) {
		super();
		this.ratingId = ratingId;
		this.ratingLabel = ratingLabel;
	}

	public long getRatingId() {
		return ratingId;
	}

	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingLabel() {
		return ratingLabel;
	}

	public void setRatingLabel(String ratingLabel) {
		this.ratingLabel = ratingLabel;
	}
	
	
	
	

}
