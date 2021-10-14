package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.Entity.BookTicket;
import com.flightapp.Repository.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public ResponseEntity<String> getAllFlights(String fromLocation, String toLocation) {
		try {
			return null;
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<BookTicket> saveBookTcket(String flightNumber, BookTicket bookTicket) {
		try {
		    return new ResponseEntity<>(userRepo.save(bookTicket), HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<BookTicket>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
