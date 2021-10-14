package com.flightapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.entity.AirLine;

public interface AirLineRepo extends JpaRepository<AirLine,String> {

	
	  @Query("select a from AirLine a where airLineCode=:airLineCode") AirLine
	  findByAirLineCode(@Param("airLineCode") String airCode);
	 
}
