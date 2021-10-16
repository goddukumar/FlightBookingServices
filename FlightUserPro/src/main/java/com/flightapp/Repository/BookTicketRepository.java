package com.flightapp.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.Entity.BookTicket;

public interface BookTicketRepository extends JpaRepository<BookTicket, Integer> {

	@Query("SELECT BT FROM BookTicket BT WHERE BT.email LIKE ?1%")
	List<BookTicket> searchByEmail(String email);

	@Query("SELECT BT FROM BookTicket BT WHERE BT.pnrNo LIKE ?1%")
	List<BookTicket> searchByPnr(String pnrNo);

	@Transactional	
	@Modifying
	@Query("UPDATE BookTicket BT SET BT.status = :status WHERE BT.pnrNo = :pnrNo")
	int cancelTicket(String pnrNo, String status);
}
