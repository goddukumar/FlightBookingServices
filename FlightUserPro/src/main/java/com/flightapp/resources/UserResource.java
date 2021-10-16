package com.flightapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.Entity.BookTicket;
import com.flightapp.Entity.FlightSchedule;
import com.flightapp.dto.BookTicketDTO;
import com.flightapp.dto.SearchFlightDto;
import com.flightapp.service.UserService;

@RestController
public class UserResource {

	private UserService userService;

	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/searchFlights")
	public ResponseEntity<List<SearchFlightDto>> search(@RequestParam String fromLocation,
			@RequestParam String toLocation,@RequestParam String departurdate) {
		return userService.serachFlights(fromLocation, toLocation,departurdate);
	}

	@PostMapping(value = "bookTicket/{flightNumber}")
	public ResponseEntity<BookTicket> bookTicket(@PathVariable String flightNumber, @RequestBody BookTicketDTO bookTicket) {
		return userService.bookTicket(flightNumber, bookTicket);

	}

	@GetMapping(value = "/search/email/{email}")
	public List<BookTicket> searchByEmail(@PathVariable String email) {
			return userService.searchByEmail(email);
	}

	@GetMapping(value = "/search/pnr/{pnrNo}")
	public List<BookTicket> searchByPnr(@PathVariable String pnrNo) {
			return userService.searchByPnr(pnrNo);
	}
	
	@PutMapping(value = "/cancel/{pnrNo}")
    public boolean cancelTicket(@PathVariable String pnrNo) {
            return userService.cancelTicket(pnrNo);
    }

}
