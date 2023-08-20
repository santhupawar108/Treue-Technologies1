package com.pawar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawar.model.*;
import com.pawar.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public void saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		bookingRepository.save(booking);
	}
	
	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public void save(Booking booking) {
		// TODO Auto-generated method stub
		
		bookingRepository.save(booking);
		
	}

	@Override
	public List<Booking> getUserBookings(User user) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUser(user);
	}

}
