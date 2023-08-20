package com.pawar.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pawar.model.Candidate;
import com.pawar.model.*;
import com.pawar.model.Vote;
import com.pawar.repo.Candidaterepository;
import com.pawar.repo.UserRepository;
import com.pawar.repo.VoteRepository;


@Controller
public class VotingController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoteRepository voteRepository;
	
	@Autowired
	private Candidaterepository candidateRepository;
	

	@GetMapping("/vote")
	public String userpage(@ModelAttribute Vote  theVote,Model theModel) {
			

        Optional<User> user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.isPresent() ) {
        	User theUser= user.get();
         //   Candidate name =candidateRepository.findBy();
        	
        	if(!voteRepository.existsByUser(user)) {
        	theModel.addAttribute("candidates", candidateRepository.findAll());
        	theModel.addAttribute("vote", new Vote());
        	
            return "votingpage";
        }else {
        	Candidate votedCandidate =voteRepository.findByUser(user).getCandidate();
        	theModel.addAttribute("message", "Your already voted");
        	theModel.addAttribute("votedCandidate", votedCandidate);
        	
        	
            return "votingpage";
        }
        }
        return "redirect:/vote";
	}
	
 
	@PostMapping("/vote")
	 public String voteUser(@ModelAttribute Vote  theVote, Model theModel )
	 {
		
		Optional<User> user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<Candidate> candidate = candidateRepository.findById(theVote.getCandidate().getId());
        if (user.isPresent() && candidate.isPresent()) {
        	theVote.setUser(user.get());
        	theVote.setCandidate(candidate.get());
            voteRepository.save(theVote);
            
        }
	
		 return "redirect:/vote";
	 }
	
/**	
	**/
	
	
	

}
