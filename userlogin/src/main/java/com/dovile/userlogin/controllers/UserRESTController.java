package com.dovile.userlogin.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dovile.userlogin.entities.Records;
import com.dovile.userlogin.entities.User;
import com.dovile.userlogin.repos.UserRepository;



@RestController
@RequestMapping("/users")
public class UserRESTController {
	
	@Autowired
	UserRepository userRepository;

	
	//Get All User
//	@GetMapping
//	public List<User> getLocations(){
//		return userRepository.findAll();
//	}
//	
	//Get by ID
	@GetMapping("/{id}")
	public User getLocation(@PathVariable("id") long id) {
		return userRepository.findById(id).get();
		
	}
	
	//Create New
	@PostMapping
	public User createLoacation(@RequestBody User user) {
		user.setPassword(user.hardcodePass(user.getPassword()));
		return userRepository.save(user);
		
	}
	
	//Login by email and password and see all list of records 
	@GetMapping
	public List<Records> login(@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
		User user = userRepository.findByEmail(email);
		List<Records> records;
		if (user.getPassword().equals(user.hardcodePass(password))) {
			 records= user.getRecords();
			 return records;
		}
		return null;
	}
	


}
