package rs.ac.uns.ftn.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.admin.model.FacilityType;

@Repository
public interface TypeRepository extends JpaRepository<FacilityType, Long>  {

	FacilityType findOneByName(String name);
	FacilityType saveAndFlush(FacilityType facilityType);
}
