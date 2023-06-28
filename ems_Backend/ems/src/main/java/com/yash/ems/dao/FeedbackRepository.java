package com.yash.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer > {

}
