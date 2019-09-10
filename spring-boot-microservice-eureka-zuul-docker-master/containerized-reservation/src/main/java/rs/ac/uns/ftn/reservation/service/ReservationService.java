package rs.ac.uns.ftn.reservation.service;

import java.util.List;

import rs.ac.uns.ftn.reservation.dto.ReservationDTO;
import rs.ac.uns.ftn.reservation.dto.ReserveDTO;
import rs.ac.uns.ftn.reservation.model.Reservation;

public interface ReservationService {

	int makeReservation(ReservationDTO dto);
	List<Reservation> findReservationsByGuestUsername(String username);
	Reservation cancelReservation(Long id);
//	Reservation realizeReservation(Long id);
	boolean agentMakeReservation(Reservation reservation);
}
