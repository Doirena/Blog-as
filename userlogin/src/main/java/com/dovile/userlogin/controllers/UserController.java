package com.dovile.userlogin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dovile.userlogin.entities.Records;
import com.dovile.userlogin.entities.User;
import com.dovile.userlogin.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	// The main page
	@RequestMapping("/showMain")
	public String showMainPage() {
		return "login/index";
	}

	// New User create page
	@RequestMapping("/newUser")
	public String showNewUserPage() {
		return "login/newUser";
	}

	// When create new User, come back to the main page
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
	
		user.setPassword(user.hardcodePass(user.getPassword()));
		userRepository.save(user);
		return "login/index";
	}

	// New Login page
	@RequestMapping("/loginUser")
	public String showLoginPage() {
		return "login/login";
	}

	// User login action and go to user records page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepository.findByEmail(email);

		if (user.getPassword().equals(user.hardcodePass(password))) {
			Long userId = user.getId();
			List<Records> records = user.getRecords();
			modelMap.addAttribute("records", records);
			modelMap.addAttribute("userId", userId);
			return "userRecords";
		} else {
			modelMap.addAttribute("msg", "Invalid user name or password. Please try again");
		}
		return "login/login";

	}

}
