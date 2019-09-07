package rs.ac.uns.ftn.reservation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.reservation.dto.ReservationDTO;
import rs.ac.uns.ftn.reservation.dto.ReserveDTO;
import rs.ac.uns.ftn.reservation.dto.SearchFormParamsDTO;
import rs.ac.uns.ftn.reservation.model.AccommodationFacility;
import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.Reservation;
import rs.ac.uns.ftn.reservation.service.FacilityService;
import rs.ac.uns.ftn.reservation.service.ReservationService;
import rs.ac.uns.ftn.reservation.service.UnitService;

@RestController
@RequestMapping("/api/res")
public class ReservationController
{
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	FacilityService facilityService;
	
	@Autowired
	ReservationService reservationService;

	@GetMapping("/hello")
	public ResponseEntity get()
	{
		return new ResponseEntity("Hello from service 3!", HttpStatus.OK);
	}
	
	@PostMapping(value="/getFreeUnits/{facId}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFreeUnit(@PathVariable(value="facId") Long id,@Valid @RequestBody SearchFormParamsDTO sfp){
		List<AccommodationUnit> au=unitService.findAvailableUnitsInFacility(id, sfp.getCheckIn(), sfp.getCheckOut());
		return new ResponseEntity<>(au,HttpStatus.OK);
	}
	
	@GetMapping(value="/getFacility/{facId}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFreeUnit(@PathVariable(value="facId") Long id ){
		System.out.println("IDdddddddd"+id);
		Optional<AccommodationFacility> oac=this.facilityService.findByid(id);
		
		if(oac.isPresent()) {
			AccommodationFacility ofc=oac.get();
			System.out.println(ofc.getName());
			return new ResponseEntity<>(ofc,HttpStatus.OK);
			
		}else {
			System.out.println("sta ce ovce");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value="/makeReservation",
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> makeReservation(@Valid @RequestBody ReservationDTO dto){
		
		
		
		int ret=reservationService.makeReservation(dto);
		if(ret==0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/getMyReservations/{username}")
	public ResponseEntity<?> getMyReservations(@PathVariable("username") String username){
		
		List<Reservation> reservations=this.reservationService.findReservationsByGuestUsername(username);
		return new ResponseEntity<>(reservations,HttpStatus.OK);
	}
	
	@GetMapping(value="/cancelReservation/{id}")
	public ResponseEntity<?> cancleReservation(@PathVariable("id") Long id){
		this.reservationService.cancelReservation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@GetMapping(value="/getDestinations",
//			produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> getDestinations() {
//		
//		
//	}
	
	/*
	@PostMapping("/getfreeunits")
	public ResponseEntity<> getFreeAccUnits(@RequestBody) {
		
	}
	
	@PostMapping
	public ResponseEntity<> makeAReservation(@RequestBody) {
		
	}*/
}
