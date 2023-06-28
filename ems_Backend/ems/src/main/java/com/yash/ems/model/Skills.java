package com.yash.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skills {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long skill_id;

	@Column(name = "skill_name")
	private String  skillName;
	
	@Column(name = "key_skill")
	private String keySkill;

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Skills(Long skill_id, String skillName, String keySkill) {
		super();
		this.skill_id = skill_id;
		this.skillName = skillName;
		this.keySkill = keySkill;
	}



	public Long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getKeySkill() {
		return keySkill;
	}

	public void setKeySkill(String keySkill) {
		this.keySkill = keySkill;
	}
	
	
	
	

}
