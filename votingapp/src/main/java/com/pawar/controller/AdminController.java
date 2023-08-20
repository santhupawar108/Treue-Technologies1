package com.pawar.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pawar.model.Candidate;
import com.pawar.model.*;
import com.pawar.repo.Candidaterepository;
import com.pawar.repo.VoteRepository;

@Controller
public class AdminController {
	
	@Autowired
	private Candidaterepository candidateRepository;
	
	@Autowired
	private VoteRepository voteRepository;

	@GetMapping("/adminhome")
	public String listCandidates(Model theModel) 
	{
		List<Candidate> theCandidate = candidateRepository.findAll();
		
		int totalvotes = 0;
		for(Candidate candidate:theCandidate) {
			Set<Vote> votes = candidate.getVotes();
			totalvotes+=votes.size();
			
		}
        Candidate winnerCandidate=null;
        float highPercentage=0.0f;
		
		for(Candidate candidate:theCandidate) {
			Set<Vote> votes = candidate.getVotes();
			int votesCount =votes.size();
			float percentage = (votesCount*100)/totalvotes;
			candidate.setPercentage(percentage);
			
			if(percentage>highPercentage) {
				
				highPercentage=percentage;
				winnerCandidate=candidate;
			}
			
			
		}
		
			theModel.addAttribute("winnerCandidate", winnerCandidate);
			theModel.addAttribute("candidates", theCandidate);
			
		return "adminhomepage";
		
	}
	
	
	@GetMapping("/votehistory/{id}")
	public String voteHistory(@PathVariable long id, Model theModel) {
			

		Optional<Candidate> candidate =	candidateRepository.findById(id);

		

		if(candidate.isPresent()) {
			Candidate	theCandidate=candidate.get();
			List<Vote>	votes=voteRepository.findByCandidate(theCandidate);
			List<User>	votedUser=votes.stream().map(Vote::getUser).collect(Collectors.toList());
	System.out.println(votes);		
		theModel.addAttribute("currentCandidate", theCandidate);
		
    	theModel.addAttribute("votedUser", votedUser);
    	
		
			return "uservotespage";
		}
        
        
        
        return "redirect:/adminhome";
	}
	
	

	
}
