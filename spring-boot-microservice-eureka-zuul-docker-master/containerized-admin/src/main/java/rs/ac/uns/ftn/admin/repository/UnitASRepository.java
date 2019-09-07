package rs.ac.uns.ftn.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.admin.model.UnitAS;

@Repository
public interface UnitASRepository extends JpaRepository<UnitAS, Long> {

	UnitAS findOneByName(String name);
	UnitAS saveAndFlush(UnitAS unitAS);
}
