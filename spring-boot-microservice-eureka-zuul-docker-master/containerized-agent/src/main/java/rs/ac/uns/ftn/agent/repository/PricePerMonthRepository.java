package rs.ac.uns.ftn.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.agent.model.PricePerMonth;

public interface PricePerMonthRepository extends JpaRepository<PricePerMonth, Long> {

}
