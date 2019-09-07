package rs.ac.uns.ftn.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.reservation.model.PricePerMonth;



public interface PricePerMonthRepository extends JpaRepository<PricePerMonth, Long> {

}
