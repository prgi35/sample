package com.yash.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.dao.UserRepository;
import com.yash.ems.model.User;


@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		User savedUser = null;
		ResponseEntity<String> response = null;
		try {
			// Checking email is already registerd
			List<User> users = userRepository.findByEmail(user.getEmail());
			if (users.size() > 0) {
				System.out.println("Email Id is already registered");
				response = new ResponseEntity<String>("Exist",HttpStatus.ACCEPTED);
			} else {
				// String hashPwd = passwordEncoder.encode(user.getPassword());
				//user.setPassword(user.getPassword());
				user.setRole("User");
				savedUser = userRepository.save(user);
				if (savedUser.getId() > 0) {
					response = new ResponseEntity<String>("Register",HttpStatus.OK);
					System.out.println("User details are successfully registered");
				}
			}
		} catch (Exception ex) {
			response = new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
			ex.printStackTrace();
		}
		return response;
	}

	@PostMapping("/login")
	public User getUserData(@RequestBody User user) {
		User failedUser = null;
		List<User> users = userRepository.findByEmail(user.getEmail());
		if (users.size() > 0) {
			String feachPassword = users.get(0).getPassword();
			if(feachPassword.equals(user.getPassword())) {
				return users.get(0);
			}else {
				 failedUser = new User();
				 failedUser.setEmail(user.getEmail());
				 failedUser.setPassword(user.getPassword());
				 failedUser.setAuthErrorMsg("Invalid");
				 return failedUser;
			}
			
		} else {
			//When User not found
			 return null;
		}

	}
}
