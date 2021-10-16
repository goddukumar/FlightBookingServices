package com.flightapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.Entity.FlightDetails;

public interface FlightRepository extends JpaRepository<FlightDetails, String> {

}
