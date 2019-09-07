package rs.ac.uns.ftn.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.service1.model.SystemUser;
import rs.ac.uns.ftn.service1.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private AuthenticationManager authMenager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SystemUser sysUser=userRepository.findByUsername(username);
		if(sysUser == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}else {
			System.out.println("ovdi je dovar"+sysUser.getUsername());
			return sysUser;
		}
	}

}
