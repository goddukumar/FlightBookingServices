package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.FlightSchedule;
import com.flightapp.repo.FlightRepo;
import com.flightapp.repo.FlightScheduleRepo;

@Service
public class FlightScheduleService {

	private FlightScheduleRepo repo;

	@Autowired
	public FlightScheduleService(FlightScheduleRepo repo) {
		this.repo = repo;
	}

	public void addFlightSchedule(FlightSchedule flightSchedule) {
		repo.save(flightSchedule);
	}

}
