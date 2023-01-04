package com.aravind.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.flightreservation.models.User;
import com.aravind.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";

	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		
		User user = userRepo.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}
		else if(email==null & password==null) {
			modelMap.addAttribute("msg", "Please enter email and password");
		}
		else {
			modelMap.addAttribute("msg", "Incorrect Credentials");
		}
		
		return "login/login";
		
		
	}

}
