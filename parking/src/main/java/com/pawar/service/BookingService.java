package com.pawar.service;

import java.util.List;

import com.pawar.model.*;

public interface BookingService {
	
	void saveBooking(Booking booking);

	List<Booking> findAll();

	void save(Booking booking);
	
	List<Booking> getUserBookings(User user);

}
