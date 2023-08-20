package com.pawar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawar.model.ParkingSpot;
import com.pawar.repo.ParkingSpotRepository;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {
	
	@Autowired
	private ParkingSpotRepository parkingSpotRepository ;

	@Override
	public void saveParkingSpot(ParkingSpot parkingSpot) {
		// TODO Auto-generated method stub
		parkingSpotRepository.save(parkingSpot);
		
	}

	@Override
	public List<ParkingSpot> findAll() {
		// TODO Auto-generated method stub
		return parkingSpotRepository.findAll();
	}

	@Override
	public ParkingSpot findById(Long parkingSpotId) {
		// TODO Auto-generated method stub
		Optional<ParkingSpot> result= parkingSpotRepository.findById(parkingSpotId);
		ParkingSpot parkingSpot =null;
		if(result.isPresent()) 
		{
			parkingSpot = result.get();
		}
		else {throw new RuntimeException("did not find employee- "+parkingSpotId);}
		return parkingSpot;
	}

	@Override
	public void save(ParkingSpot parkingSpot) {
		// TODO Auto-generated method stub
		
		parkingSpotRepository.save(parkingSpot);
		
	}

	@Override
	public List<ParkingSpot> getAvailableParkingSports() {
		// TODO Auto-generated method stub
		return parkingSpotRepository.findByAvailable(true);
	}

	@Override
	public ParkingSpot getParkingSpotById(Long parkingSpotId) {
		// TODO Auto-generated method stub

		Optional<ParkingSpot> result= parkingSpotRepository.findById(parkingSpotId);
		ParkingSpot parkingSpot =null;
		if(result.isPresent()) 
		{
			parkingSpot = result.get();
		}
		else {throw new RuntimeException("did not find parkingSpot- "+parkingSpotId);}
		return parkingSpot;

	}

	

}
