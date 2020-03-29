package com.dovile.userlogin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dovile.userlogin.entities.Records;
import com.dovile.userlogin.entities.User;
import com.dovile.userlogin.repos.RecordRepository;
import com.dovile.userlogin.repos.UserRepository;

@Controller
public class RecordCotroller {
	
	@Autowired
	RecordRepository recordRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	
	//Delete User record
	@RequestMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("recordId") long recordId, @RequestParam("userId") long userId, ModelMap modelMap) {
	User user= userRepository.findById(userId).get();
	List<Records> records =user.getRecords();
	recordRepository.deleteById(recordId);
	modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("records", records);
		return "userRecords";	
	}
	
	//New record Page
	@RequestMapping("/showNewRecord")
	public String newRecord(@RequestParam("userId") long userId, ModelMap modelMap) {
			modelMap.addAttribute("userId", userId);
			return "showNewRecord";	
		}
	
	//Save new/edit record
	@RequestMapping("/saveRec")
	public String saveNewRecord(@ModelAttribute("record") Records record, @RequestParam("userId") long userId, ModelMap modelMap) {
		User user= userRepository.findById(userId).get();
		record.setUser(user);
		Records recordSave = recordRepository.save(record);
		List<Records> records =user.getRecords();
		modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("records", records);
		 return "userRecords";
	}
	
	
	//Edit record Page
	@RequestMapping("/showUpdateRecord")
	public String showUpdate(@RequestParam("recordId") long recordId, @RequestParam("userId") long userId, ModelMap modelMap) {
	Records record = recordRepository.findById(recordId).get();
		modelMap.addAttribute("record", record);
		modelMap.addAttribute("userId", userId);
		return "showUpdateRecord";	
	}
	
	

}
