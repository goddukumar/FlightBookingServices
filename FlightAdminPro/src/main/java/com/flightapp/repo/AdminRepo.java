package com.flightapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.AirLine;

public interface AdminRepo extends JpaRepository<AirLine,Integer>{

}
