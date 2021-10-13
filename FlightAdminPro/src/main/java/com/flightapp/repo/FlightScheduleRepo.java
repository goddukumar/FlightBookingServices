package com.flightapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.FlightSchedule;

public interface FlightScheduleRepo extends JpaRepository<FlightSchedule,Integer> {

}
