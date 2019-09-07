package rs.ac.uns.ftn.service1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.service1.dto.AgentDTO;
import rs.ac.uns.ftn.service1.dto.UserDTO;
import rs.ac.uns.ftn.service1.model.Agent;
import rs.ac.uns.ftn.service1.model.Authority;
import rs.ac.uns.ftn.service1.model.SystemUser;
import rs.ac.uns.ftn.service1.repository.AgentRepository;
import rs.ac.uns.ftn.service1.repository.RoleRepository;
import rs.ac.uns.ftn.service1.repository.UserRepository;

@Service
public class SystemUserServiceImp implements SystemUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Override
	public SystemUser findByEmail(String email) {
	// TODO Auto-generated method stu
		return this.userRepository.findByEmail(email);
	}
	
	@Override
	public Authority findByName(String name) {
		// TODO Auto-generated method stub
		return this.roleRepository.findByName(name);
	}
	
	@Override
	public void saveSystemUser(SystemUser systemUser) {
		// TODO Auto-generated method stub
		this.userRepository.saveAndFlush(systemUser);
	}
	
	@Override
	public SystemUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		List<SystemUser> allUsers=new ArrayList<>();
		allUsers=this.userRepository.findAll();
		
		List<UserDTO> users=new ArrayList<>();
		for(SystemUser u:allUsers) {
			List<Authority> authorities=(List<Authority>) u.getAuthorities();
			if(authorities.get(0).getRolename().equals("user") && u.isAccountNonLocked()) {
				users.add(new UserDTO(u));
			}
		}
		return users;
	}

	@Override
	public List<AgentDTO> findAllAgents() {
		// TODO Auto-generated method stub
		List<Agent> agents=new ArrayList<>();
		agents=this.agentRepository.findAll();
		
		List<AgentDTO> agentsDTO=new ArrayList<>();
		for(Agent a:agents) {
			
			agentsDTO.add(new AgentDTO(a.getName(), a.getSurname(), a.getUsername(), a.getPib()));
		}
		return agentsDTO;
		
		
	}
	
	
}
