package com.flightapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.FlightSchedule;
import com.flightapp.service.FlightScheduleService;

@RestController
public class FlightScheduleResource {

	private FlightScheduleService service;

	@Autowired
	public FlightScheduleResource(FlightScheduleService service) {
		this.service = service;
	}

	@PostMapping(value = "/addFlightSchedule")
	public void addSchedule(@RequestBody FlightSchedule flightSchedule) {
		service.addFlightSchedule(flightSchedule);

	}

}
