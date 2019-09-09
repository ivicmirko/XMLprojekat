package rs.ac.uns.ftn.service1.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.netflix.ribbon.proxy.annotation.Http;

import rs.ac.uns.ftn.service1.dto.AgentAddDTO;
import rs.ac.uns.ftn.service1.dto.AgentDTO;
import rs.ac.uns.ftn.service1.dto.LoginRequestDTO;
import rs.ac.uns.ftn.service1.dto.ProfileDTO;
import rs.ac.uns.ftn.service1.dto.RegisterUserDTO;
import rs.ac.uns.ftn.service1.dto.UserDTO;
import rs.ac.uns.ftn.service1.model.Agent;
import rs.ac.uns.ftn.service1.model.Authority;
import rs.ac.uns.ftn.service1.model.SystemUser;
import rs.ac.uns.ftn.service1.repository.AgentRepository;
import rs.ac.uns.ftn.service1.repository.RoleRepository;
import rs.ac.uns.ftn.service1.repository.UserRepository;
import rs.ac.uns.ftn.service1.security.JwtAuthResponse;
import rs.ac.uns.ftn.service1.security.JwtTokenProvider;
import rs.ac.uns.ftn.service1.service.SystemUserService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	private SystemUserService systemUserService;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	private JwtTokenProvider  jwtTokenProvider;
	
	
	@PostMapping(value="/login",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO loginUser){
	
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"+loginUser.getUsername());
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
		Authentication authentication=authenticationManager.authenticate(token);
		
		System.out.println("BBBBBBBBBBBBBBBBAAAAAAAAAAAAAAA");
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName()+" adgedthsrgdf");
		
		String jwt=jwtTokenProvider.generateToken(authentication);

		System.out.println("aaaaaaaa"+jwt);
			
		List<String> authorities = authentication.getAuthorities().stream()
    				.map(GrantedAuthority::getAuthority)
    				.collect(Collectors.toList());
			ProfileDTO profileDTO=new ProfileDTO(authentication.getName(), jwt, authorities);
	        return ResponseEntity.ok(profileDTO);

		
		//return new ResponseEntity<LoginRequestDTO>(loginUser,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/logout")
	public void logout(){
		System.out.println("LOGOUT");
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
	}
	
	@GetMapping("/getLogged")
	public ResponseEntity<?> getLogged(HttpServletRequest request){
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		
		
		
		SystemUser user=this.systemUserService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		if(user !=null){
			List<String> authorities = user.getAuthorities().stream()
    				.map(GrantedAuthority::getAuthority)
    				.collect(Collectors.toList());
			System.out.println("Id:"+user.getId());
			ProfileDTO profile=new ProfileDTO(user.getUsername(),request.getHeader("Buckuris"), authorities);
			profile.setId(user.getId());
			
			return new ResponseEntity<ProfileDTO>(profile,HttpStatus.OK);
		}else {
			System.out.println("eles");
			return new ResponseEntity<>("Fail",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value="/signup",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserDTO registerUserDTO){
		
		if(systemUserService.findByEmail(registerUserDTO.getEmail()) != null) {
			return new ResponseEntity<>("Postoji nalog s ovim email-om", HttpStatus.BAD_REQUEST);
		}
		
		if(systemUserService.findByEmail(registerUserDTO.getEmail()) != null) {
			return new ResponseEntity<>("Postoji vec username", HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			List<Authority> authorities=new ArrayList<>();
			authorities.add(roleRepository.findByName("user"));
			SystemUser user=new SystemUser(registerUserDTO.getUsername(), registerUserDTO.getName(), registerUserDTO.getSurname(),
					registerUserDTO.getAddress(), registerUserDTO.getPhoneNum(), registerUserDTO.getEmail(), passwordEncoder.encode(registerUserDTO.getPassword()),
	   				authorities);
			user.setActive(true);
			user.setRemoved(true);
			systemUserService.saveSystemUser(user);
			return new ResponseEntity<SystemUser>(user,HttpStatus.CREATED);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("aaa nece");
		
		}
		
		return null;
		
	}
	
	@PostMapping(value="/addagent",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAgent(@RequestBody AgentAddDTO user){
		
		if(systemUserService.findByEmail(user.getEmail()) != null) {
			return new ResponseEntity<>("Postoji nalog s ovim email-om", HttpStatus.BAD_REQUEST);
		}
		
		if(systemUserService.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<>("Postoji vec username", HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			List<Authority> authorities=new ArrayList<>();
			authorities.add(roleRepository.findByName("agent"));
			SystemUser agentUser=new SystemUser(user.getUsername(), user.getName(), user.getSurname(),
					user.getAddress(), user.getPhoneNum(), user.getEmail(), passwordEncoder.encode(user.getPassword()),
	   				authorities);
			agentUser.setActive(true);
			agentUser.setRemoved(true);
//			systemUserService.saveSystemUser(agentUser);
//			
//			agentUser=systemUserService.findByUsername(agentUser.getUsername());
			
			Agent agent=new Agent(agentUser);
			agent.setPib(user.getPib());
			
			this.agentRepository.saveAndFlush(agent);
			
			return new ResponseEntity(HttpStatus.CREATED);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("aaa nece");
		
		}
		
		return null;
	}
	
	@GetMapping(value="/getAllUsers")
	public ResponseEntity<?> getAllUsers(){
		
		List<UserDTO> users=this.systemUserService.findAllUsers();
		
		return new ResponseEntity<List<UserDTO>>(users,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllAgents")
	public ResponseEntity<?> getAllAgents(){
		List<AgentDTO> agents=this.systemUserService.findAllAgents();
		return new ResponseEntity<List<AgentDTO>>(agents,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/blockUser/{username}")
	public ResponseEntity<?> blockUser(@PathVariable("username") String username){
		SystemUser user=this.systemUserService.findByUsername(username);
		user.setActive(false);
		this.userRepository.save(user);
		
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping(value="/unblockUser/{username}")
	public ResponseEntity<?> unblockUser(@PathVariable("username") String username){
		SystemUser user=this.systemUserService.findByUsername(username);
		user.setActive(true);
		this.userRepository.save(user);
		
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping(value="/deleteUser/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
		SystemUser user=this.systemUserService.findByUsername(username);
		user.setRemoved(false); //treba da bude isNotRemoved
		this.userRepository.save(user);
		
		
		return new ResponseEntity(HttpStatus.OK);
	}
}
