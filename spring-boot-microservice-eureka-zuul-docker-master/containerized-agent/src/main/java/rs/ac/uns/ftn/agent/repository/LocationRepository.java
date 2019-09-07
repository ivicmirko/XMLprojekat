package rs.ac.uns.ftn.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.agent.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
