package rs.ac.uns.ftn.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.service1.model.Authority;

public interface RoleRepository extends JpaRepository<Authority, Long>{
	
	Authority findByName(String name);

}
