package rs.ac.uns.ftn.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.reservation.model.FacilityType;
@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long> {

	List<FacilityType> findAll();
}
