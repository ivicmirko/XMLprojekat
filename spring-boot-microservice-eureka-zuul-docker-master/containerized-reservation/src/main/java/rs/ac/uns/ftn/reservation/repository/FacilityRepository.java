package rs.ac.uns.ftn.reservation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.reservation.model.AccommodationFacility;
@Repository
public interface FacilityRepository extends JpaRepository<AccommodationFacility, Long>{
	
	List<AccommodationFacility> findAll();
	List<AccommodationFacility> findByDestinationName(String name);
	Optional<AccommodationFacility> findByid(Long id);

}
