package com.pawar.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawar.model.*;
import com.pawar.repo.BookingRepository;
import com.pawar.repo.ParkingSpotRepository;
import com.pawar.repo.UserRepository;


@Controller
@RequestMapping("/parking")
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	
	
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
	
	 @GetMapping("/dashboard")
	    public String showDashboardPage(Model model) {
	    	
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        System.out.print(authentication);
	        String username = authentication.getName();
	       Optional<User> user = userRepository.findByUsername(username);
	        List<Booking> bookings = bookingRepository.findByUser(user);
	        
	        model.addAttribute("bookings", bookings);
	        return "dashboard";
	    }
	
	    @PostMapping("/cancel/{bookingId}")
	    public String cancelBooking(@PathVariable("bookingId") Long bookingId) {
	        Booking booking = bookingRepository.findById(bookingId).orElse(null);
	        if (booking != null) {
	            ParkingSpot parkingSpot = booking.getParkingSpot();
	            parkingSpot.setAvailable(true);
	            parkingSpotRepository.save(parkingSpot);
	            
	            bookingRepository.delete(booking);
	        }
	        
	        return "redirect:/parking/dashboard";
	    }
	
	
}
