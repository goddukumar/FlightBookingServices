package com.flightapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.Entity.AirLine;

public interface AirlineRepository extends JpaRepository<AirLine, String> {
	

}
