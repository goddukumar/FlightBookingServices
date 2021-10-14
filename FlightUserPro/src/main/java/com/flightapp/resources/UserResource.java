package com.flightapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.Entity.BookTicket;
import com.flightapp.service.UserService;

@RestController
public class UserResource {

	private UserService service;

	@Autowired
	public UserResource(UserService service) {
		this.service = service;
	}

	@GetMapping(value = "/searchFlights")
	public void searchFlights(@RequestParam String fromLocation, @RequestParam String toLocation) {
		service.getAllFlights(fromLocation,toLocation);
	}
	
	@PostMapping("/bookFlightTicket/{flightNumber}")
	public ResponseEntity<BookTicket> ticketBook(@PathVariable String flightNumber,@RequestBody BookTicket bookTicket)
	{
		return service.saveBookTcket(flightNumber,bookTicket);
	}

}
