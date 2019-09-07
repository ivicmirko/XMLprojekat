package rs.ac.uns.ftn.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.service1.dto.ProfileDTO;
import rs.ac.uns.ftn.service1.service.SystemUserService;

@RestController
@RequestMapping("/api/auth/test")
public class TestController
{
	@Autowired
	SystemUserService systemUserService;

	@GetMapping("/hello")
	public ResponseEntity<?> get()
	{
		System.out.println("aeeeee");
		return ResponseEntity.ok("Hello from the other side");
	}
	
	@GetMapping("/secured/hello")
	public ResponseEntity<?> getSecured()
	{
		return new ResponseEntity<String>("Seucred service", HttpStatus.OK);
	}
	
	@GetMapping("/authorised/hello")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity getAuthorised()
	{
		return ResponseEntity.ok("Hello from the other side");
	}
	
	
}
