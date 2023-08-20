package com.pawar.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawar.model.ParkingSpot;
import com.pawar.service.ParkingSpotService;


@Controller
@RequestMapping("/parking")
public class ParkingSpotController {
	
	@Autowired
	private ParkingSpotService parkingSpotService;
	
	
	
	
	  @GetMapping("/search")
	    public String showSearchPage(Model model) {
		  List<ParkingSpot> parkingSpots = parkingSpotService.getAvailableParkingSports();
		  model.addAttribute("parkingSpots",parkingSpots);
			return "search";
		  
	  }
	  
		
		  @GetMapping("/addparking")
		    public String showParkingPage(Model model) {
			  
			  model.addAttribute("parkingSpot",new ParkingSpot());
			  
				return "addparkings";
			  
		  }
		
		  
		  @PostMapping("/addparking")
		    public String addParkingPage(@ModelAttribute("parkingSpot") ParkingSpot parkingSpot) {
			  
			  parkingSpot.setAvailable(true);
			  parkingSpotService.saveParkingSpot(parkingSpot);
			  
		
			  
				return "redirect:/parking/addparking";
			  
		  }
		  
		  
		

}
