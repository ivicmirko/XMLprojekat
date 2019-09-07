package rs.ac.uns.ftn.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.agent.model.FacilityAS;


@Repository
public interface FacilityASRepository extends JpaRepository<FacilityAS, Long> {
	
	List<FacilityAS> findAll();

}
