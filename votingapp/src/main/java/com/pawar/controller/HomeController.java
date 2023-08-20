package com.pawar.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawar.model.User;
import com.pawar.repo.UserRepository;


@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/loginpage")
	public String logipage(@RequestParam(value = "error",required = false) String error, Model model) {
		
		if(error != null) {
			model.addAttribute("loginError", true);	
		}
		
		return "login";
	}
	

	
	
	@GetMapping("/register")
	public String registerpage(Model theModel) {
		User theUser = new User();
		theModel.addAttribute("userinfo", theUser);
		
		return "registration";
	}
	
	

    
	
	@PostMapping("/register")
	 public String registerUser(@ModelAttribute("userinfo") User theUserinfo, Model theModel)
	 {
		
		theUserinfo.setPassword(passwordEncoder.encode(theUserinfo.getPassword()));
		theUserinfo.setRole("USER");
		userRepository.save(theUserinfo);
		
		theModel.addAttribute("registrationSuccess", true);
		 return "login";
	 }
	
	
	
	
}
