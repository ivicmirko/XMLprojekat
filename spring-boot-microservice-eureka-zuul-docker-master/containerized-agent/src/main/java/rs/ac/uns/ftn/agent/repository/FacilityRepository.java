package rs.ac.uns.ftn.agent.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.agent.model.AccommodationFacility;


@Repository
public interface FacilityRepository extends JpaRepository<AccommodationFacility, Long>{
	
	List<AccommodationFacility> findAll();
	List<AccommodationFacility> findByDestinationName(String name);
	AccommodationFacility findOneByid(Long id);

}
