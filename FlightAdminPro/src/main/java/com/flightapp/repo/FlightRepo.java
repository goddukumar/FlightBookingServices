package com.flightapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.entity.FlightDetails;

public interface FlightRepo extends JpaRepository<FlightDetails,String> {

	
	  @Query("select f from FlightDetails f where f.airLine.airLineCode=:airCode")
	  List<FlightDetails> getFlightDetailsByAirCode(String airCode);
	 
	

}
