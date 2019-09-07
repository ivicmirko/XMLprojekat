package rs.ac.uns.ftn.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.agent.model.Reservation;




@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findAll();
	List<Reservation> findByGuestUserName(String username);
	Reservation findOneById(Long id);
}
