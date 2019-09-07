package rs.ac.uns.ftn.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.reservation.model.Location;


public interface LocationRepository extends JpaRepository<Location, Long> {

}
