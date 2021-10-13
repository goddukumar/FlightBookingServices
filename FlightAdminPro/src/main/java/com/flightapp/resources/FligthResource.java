package com.flightapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.FlightDetails;
import com.flightapp.service.FlightService;

@RestController
public class FligthResource {

	private FlightService service;

	@Autowired
	public FligthResource(FlightService service) {
		this.service = service;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<FlightDetails> addFlight(@RequestBody FlightDetails flight) {
		 return ResponseEntity.ok().body(service.addFligth(flight));
	}

}
