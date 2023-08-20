package com.pawar.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pawar.config.CustomDetailsService;
import com.pawar.model.Booking;
import com.pawar.model.ParkingSpot;
import com.pawar.model.User;
import com.pawar.repo.UserRepository;
import com.pawar.service.BookingService;
import com.pawar.service.ParkingSpotService;


@Controller
@RequestMapping("/parking")
public class BookingController {
	
	
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired 
	private CustomDetailsService customDetailsService;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ParkingSpotService parkingSpotService;
	
	
	 @GetMapping("/confirm/{parkingSpotId}")
	    public String showConfirmationPage(@PathVariable("parkingSpotId") Long parkingSpotId, Model model, Principal principal) {
	        ParkingSpot parkingSpot = parkingSpotService.findById(parkingSpotId);
	        if (parkingSpot == null || !parkingSpot.isAvailable()) {
	        	
	        	
	            return "redirect:/parking/search";
	        }
	        
			
			String	username = principal.getName();
			
	      //  User user = customDetailsService.getUserByUsername(username);
	        	model.addAttribute("parkingSpot", parkingSpot);
		        model.addAttribute("booking", new Booking());
		        return "confirm";
	        	
	        
	        
	        
	    }
	 

	@PostMapping("/confirm/{parkingSpotId}")
	    public String confirmBooking(@PathVariable("parkingSpotId") Long parkingSpotId, @ModelAttribute("booking") Booking booking, Principal principal) {
	        ParkingSpot parkingSpot = parkingSpotService.getParkingSpotById(parkingSpotId);
	        if (parkingSpot == null || !parkingSpot.isAvailable()) {
	        	
	        	return "redirect:/parking/search";   
	            }
	       String username = principal.getName();
	        User user = userRepository.getUserByUsername(username);
	        //System.out.println(user);
        	booking.setParkingSpot(parkingSpot);
	        booking.setBookingDate(LocalDateTime.now());
	        booking.setUser(user);
	        bookingService.saveBooking(booking);
	        
	        parkingSpot.setAvailable(false);
	        parkingSpotService.save(parkingSpot);
	        
	        return "redirect:/parking/dashboard";
	        
	    }
	 
	 

}
