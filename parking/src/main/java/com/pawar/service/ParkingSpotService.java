package com.pawar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pawar.model.ParkingSpot;


public interface ParkingSpotService {

	void saveParkingSpot(ParkingSpot parkingSpot);
	 List<ParkingSpot> findAll();
	ParkingSpot findById(Long parkingSpotId);
	void save(ParkingSpot parkingSpot);
	
	List<ParkingSpot> getAvailableParkingSports();
	ParkingSpot getParkingSpotById(Long parkingSpotId);

}
