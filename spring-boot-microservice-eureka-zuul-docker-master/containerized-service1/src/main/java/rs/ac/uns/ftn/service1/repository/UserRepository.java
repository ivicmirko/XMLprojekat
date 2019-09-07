package rs.ac.uns.ftn.service1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.service1.model.SystemUser;

@Repository
public interface UserRepository extends JpaRepository<SystemUser, Long> {
	
	SystemUser findByEmail(String email);
	SystemUser findByUsername(String username);
	SystemUser saveAndFlush(SystemUser systemUser);
	SystemUser findOneById(Long id);

}
