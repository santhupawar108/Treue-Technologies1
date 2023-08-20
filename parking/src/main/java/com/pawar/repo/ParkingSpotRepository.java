package com.pawar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawar.model.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

	List<ParkingSpot> findByAvailable(Boolean available);

	//List<ParkingSpot> findByAvailabele(boolean available);

}
