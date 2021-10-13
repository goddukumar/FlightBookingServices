package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AirLine;
import com.flightapp.repo.AdminRepo;

@Service
public class AdminService {
	private AdminRepo repo;

	@Autowired
	public AdminService(AdminRepo repo) {
		this.repo = repo;
	}

	public AirLine addAirLines(AirLine airLine) {
		
		return repo.save(airLine);
		
	}

}
