package com.flightapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.FlightSchedule;

public interface SearchFlightRepository extends JpaRepository<FlightSchedule, Long> {
    @Query("SELECT FS FROM FlightSchedule FS WHERE FS.fromLocation LIKE ?1% and FS.toLocation LIKE ?2%")
    List<FlightSchedule> findScheduledFlights(String fromLocation, String toLocation);

    @Query("SELECT FS FROM FlightSchedule FS WHERE FS.flightNumber = ?1")
    Optional<FlightSchedule> findScheduledFlight(String flightNumber);

}
