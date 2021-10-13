package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.FlightDetails;
import com.flightapp.repo.FlightRepo;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepo repo;

	public FlightDetails addFligth(FlightDetails flight) {
		return repo.save(flight);
	}

}
