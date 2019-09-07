package rs.ac.uns.ftn.service1.service;

import java.util.List;

import rs.ac.uns.ftn.service1.dto.AgentDTO;
import rs.ac.uns.ftn.service1.dto.UserDTO;
import rs.ac.uns.ftn.service1.model.Authority;
import rs.ac.uns.ftn.service1.model.SystemUser;

public interface SystemUserService {
	SystemUser findByEmail(String email);
	Authority findByName(String name);
	void saveSystemUser(SystemUser systemUser);
	SystemUser findByUsername(String username);
	List<UserDTO> findAllUsers();
	List<AgentDTO> findAllAgents();
	
}
