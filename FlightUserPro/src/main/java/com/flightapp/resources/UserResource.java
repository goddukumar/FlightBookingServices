package com.flightapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.BookTicketDTO;
import com.flightapp.service.UserService;

@RestController
public class UserResource {

	 @Autowired
	    private UserService userService;


	    @GetMapping(value = "/search")
	    public ResponseEntity search(@RequestParam String fromLocation, @RequestParam String toLocation) {
	            return ResponseEntity.ok().body(userService.findFlightSchedule(fromLocation, toLocation));
	    }

	    @PostMapping(value = "/book/{flightNumber}")
	    public ResponseEntity book(@PathVariable String flightNumber, @RequestBody BookTicketDTO bookTicketDTO) {
	       
	            return ResponseEntity.ok().body(userService.bookTicket(flightNumber, bookTicketDTO));
	       
	    }

	    @PutMapping(value = "/cancel/{pnrNo}/{status}")
	    public ResponseEntity cancelTicket(@PathVariable String pnrNo, @PathVariable String status) {
	            return ResponseEntity.ok().body(userService.cancelTicket(pnrNo, status));
	    }

	    @GetMapping(value = "/search/email")
	    public ResponseEntity searchByEmail(@RequestParam String email) {
	          return ResponseEntity.ok().body(userService.searchByEmail(email));
	        
	    }

	    @GetMapping(value = "/search/pnrNo")
	    public ResponseEntity searchByPnr(@RequestParam String pnrNo) {
	       
	            return ResponseEntity.ok().body(userService.searchByPnr(pnrNo));
	        
	    }

}
