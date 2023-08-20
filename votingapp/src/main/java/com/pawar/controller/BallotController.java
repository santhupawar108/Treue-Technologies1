package com.pawar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pawar.model.*;
import com.pawar.repo.Candidaterepository;
import com.pawar.repo.UserRepository;

@Controller
public class BallotController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Candidaterepository candidaterepository;
	
	
	
	
	@GetMapping("/create")
	public String candidatepage(Model theModel) {
		Candidate theCandidate = new Candidate();
		theModel.addAttribute("candidateinfo", theCandidate);
		
		return "createcandidate";
	}
	
	

    
	
	@PostMapping("/create")
	 public String registerCandidate(@ModelAttribute("candidateinfo") Candidate theCandidate, Model theModel)
	 {
		
		candidaterepository.save(theCandidate);
		
		theModel.addAttribute("registrationSuccess", true);
		 return "adminhomepage";
	 }

}
