package com.yash.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.dao.RatingMasterDao;
import com.yash.ems.model.RatingMaster;

@Service
public class RatingMasterServiceImpl implements RatingMasterService {

	@Autowired
	private RatingMasterDao rRepo;
	
	
	@Override
	public List<RatingMaster> getRating() {
		return rRepo.findAll();
	}

}
