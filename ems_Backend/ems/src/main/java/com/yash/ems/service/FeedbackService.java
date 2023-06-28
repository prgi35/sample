package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.Feedback;

public interface FeedbackService {
	
	List<Feedback> getFeedback();
	
	Feedback saveFeedback(Feedback feedback);
	  
	Feedback getsinglefeedback(int id);
	
	void deleteFeedback(int id);
	
	Feedback updateFeedback(Feedback feedback);

}
