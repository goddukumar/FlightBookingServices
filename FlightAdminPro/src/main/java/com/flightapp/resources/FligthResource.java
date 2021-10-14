package com.flightapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.AirLineBasedFlightDtls;
import com.flightapp.entity.FlightDetails;
import com.flightapp.service.FlightService;

@RestController
public class FligthResource {

	private FlightService service;

	@Autowired
	public FligthResource(FlightService service) {
		this.service = service;
	}

	@GetMapping("/getFlightsByAirCode/{airCode}")
	public ResponseEntity<AirLineBasedFlightDtls> getAllFlightDetailsByAirCode(@PathVariable String airCode) {
		return service.getAllFligthDetailsByAirLineCode(airCode);
	}

	@PostMapping(value = "/addFlight")
	public ResponseEntity<FlightDetails> addFlight(@RequestBody FlightDetails flight) {
		return service.addFligth(flight);
	}
	
	@PutMapping("/updateFlight/{id}")
	public ResponseEntity<FlightDetails> updateFlight(@PathVariable("id") String flightNumber,@RequestBody FlightDetails flight) {
		 return service.updateFlight(flightNumber,flight);
	}

	@DeleteMapping("deleteFlight/{flightNumber}")
	public boolean deleteFlight(@PathVariable String flightNumber){
			return service.deleteFlight(flightNumber);
	}

}
