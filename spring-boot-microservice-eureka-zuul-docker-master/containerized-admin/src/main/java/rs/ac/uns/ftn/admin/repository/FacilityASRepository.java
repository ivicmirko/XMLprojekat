package rs.ac.uns.ftn.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.admin.model.FacilityAS;

@Repository
public interface FacilityASRepository extends JpaRepository<FacilityAS, Long> {

	FacilityAS findOneByName(String name);
	FacilityAS saveAndFlush(FacilityAS facilityAS);
}
