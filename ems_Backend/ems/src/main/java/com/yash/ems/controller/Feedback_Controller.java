package com.yash.ems.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Feedback;
import com.yash.ems.model.RatingMaster;
import com.yash.ems.service.FeedbackService;
import com.yash.ems.service.RatingMasterService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class Feedback_Controller {
	
	@Autowired
	private FeedbackService fservice;
	
	@Autowired
	private RatingMasterService rRepo;
	
	@GetMapping("/getAllfeedback")
	public List<Feedback> getfeedback() {
		return fservice.getFeedback() ;
	}
	 	 
	@PostMapping("/postfeedback")
	public Feedback saveFeedback(@RequestBody Feedback feedback) {
		return fservice.saveFeedback(feedback);
	}
	
	@GetMapping("/getfeedback/{id}")
	public Feedback getFeedback(@PathVariable("id") int id ) {
		return fservice.getsinglefeedback(id);
	}
	  
	@DeleteMapping("/deletefeedback/{id}")
	public void deteleFeedback(@PathVariable int id) {
		fservice.deleteFeedback(id); 
	}
	
	@PutMapping("/updatefeedback/{id}")
	public Feedback updatefeedback(@PathVariable int id ,@RequestBody Feedback feedback) {
		feedback.setFeedback_id(id);
		return fservice.updateFeedback(feedback);
	}
	
	@GetMapping("/ratings")
	public List<RatingMaster> getRating(){
		return rRepo.getRating();
	}
}
