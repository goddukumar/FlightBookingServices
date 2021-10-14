package com.flightapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.Entity.BookTicket;

public interface UserRepo extends JpaRepository<BookTicket,String> {

}
