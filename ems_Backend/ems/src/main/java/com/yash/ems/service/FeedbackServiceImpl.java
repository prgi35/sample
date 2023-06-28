package com.yash.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.dao.FeedbackRepository;
import com.yash.ems.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository fRepo;
	
	
	@Override
	public List<Feedback> getFeedback() {
		return fRepo.findAll();
	}


	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return fRepo.save(feedback);
	}


	@Override
	public Feedback getsinglefeedback(int id) {
		Optional<Feedback> feedback = fRepo.findById(id);
		if (feedback.isPresent()) {
			return feedback.get();
		}
		throw new RuntimeException("Feedback not found for the" +id);
	}


	@Override
	public void deleteFeedback(int id) {
		fRepo.deleteById(id);
		
	}


	@Override
	public Feedback updateFeedback(Feedback feedback) {
		return fRepo.save(feedback);
	}

	

	

}
