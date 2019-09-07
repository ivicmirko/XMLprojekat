package rs.ac.uns.ftn.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.reservation.model.AccommodationUnit;

@Repository
public interface UnitRepository extends JpaRepository<AccommodationUnit, Long> {

	List<AccommodationUnit> findAll();
	List<AccommodationUnit> findByAccommodationFacilityId(Long id);
	AccommodationUnit findOneById(Long id);
}
