package com.dovile.userlogin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dovile.userlogin.entities.Records;
import com.dovile.userlogin.entities.User;
import com.dovile.userlogin.repos.RecordRepository;
import com.dovile.userlogin.repos.UserRepository;


@RestController
@RequestMapping("/users/records")
public class RecordsRESTController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RecordRepository recordRepository;
	
	//All List of records
	@GetMapping("/{id}")
	public List<Records> getAllList(@PathVariable("id") long id){
		return userRepository.findById(id).get().getRecords();	
	}

	//Save new record
	@PostMapping("/{id}")
	public Records saveNewRecord(@RequestBody Records record, @PathVariable("id") long id) {
		User user= userRepository.findById(id).get();
		record.setUser(user);
		Records recordSave = recordRepository.save(record);
		return recordSave;
	}
	
	//Delete records
	@DeleteMapping("/{id}")
	public void deleteLocatio(@PathVariable("id") long id) {
		recordRepository.deleteById(id);
	}
	
	
	//Update records
	@PutMapping("/{id}")
	public Records updateRecords(@RequestBody Records record, @PathVariable("id") long id) {
		User user= userRepository.findById(id).get();
		record.setUser(user);
		return recordRepository.save(record);
	}

}
