package com.flightapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.FlightDetails;

public interface FlightRepo extends JpaRepository<FlightDetails,String> {

}
