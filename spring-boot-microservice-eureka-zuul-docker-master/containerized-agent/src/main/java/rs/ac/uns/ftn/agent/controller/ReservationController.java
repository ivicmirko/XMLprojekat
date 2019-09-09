package rs.ac.uns.ftn.agent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dto.NewFacilityDTO;
import dto.NewUnitDTO;
import dto.UnitDTO;
import megatravel.data.xsd.GetAllReservationsRequest;
import megatravel.data.xsd.GetAllReservationsResponse;
import megatravel.data.xsd.GetSyncBaseRequest;
import megatravel.data.xsd.GetSyncBaseResponse;
import megatravel.data.xsd.PostNewAccommodationFacilityResponse;
import megatravel.data.xsd.PostNewUnitResponse;
import rs.ac.uns.ftn.agent.model.AccommodationFacility;
import rs.ac.uns.ftn.agent.model.AccommodationUnit;
import rs.ac.uns.ftn.agent.model.Category;
import rs.ac.uns.ftn.agent.model.Destination;
import rs.ac.uns.ftn.agent.model.FacilityAS;
import rs.ac.uns.ftn.agent.model.FacilityType;
import rs.ac.uns.ftn.agent.model.Reservation;
import rs.ac.uns.ftn.agent.model.UnitAS;
import rs.ac.uns.ftn.agent.repository.FacilityRepository;
import rs.ac.uns.ftn.agent.repository.ReservationRepository;
import rs.ac.uns.ftn.agent.repository.UnitRepository;
import rs.ac.uns.ftn.agent.service.DestinationService;
import rs.ac.uns.ftn.agent.service.FacilityService;
import rs.ac.uns.ftn.agent.service.UnitService;
import rs.ac.uns.ftn.soap.ReservationClient;

@RestController
@RequestMapping("/api/agent/res")
public class ReservationController {

	
	@Autowired
	ReservationClient reservationClient;
	
	@Autowired
	FacilityService facilityService;
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	
	@GetMapping(value="getAllReservations")
	public ResponseEntity<?> getAllReservations() {
//		System.out.println("usao u ws"+agentId);
//		GetAllReservationsRequest req=new GetAllReservationsRequest();
//		req.setAgentId(agentId);
		List<Reservation> reservations=this.reservationRepository.findAll();
		return new ResponseEntity<>(reservations,HttpStatus.OK);
	}
	
	@GetMapping(value="getAllUnits")
	public ResponseEntity<?> getAllUnits() {
//		System.out.println("usao u ws"+agentId);
//		GetAllReservationsRequest req=new GetAllReservationsRequest();
//		req.setAgentId(agentId);
		List<AccommodationUnit> units=this.unitRepository.findAll();
		List<UnitDTO> unitsDTO=new ArrayList<>();
		for(AccommodationUnit unit:units) {
			UnitDTO u=new UnitDTO();
			u.setId(unit.getId());
			u.setCapacity(unit.getCapacity());
			u.setFacilityName(unit.getAccommodationFacility().getName());
			unitsDTO.add(u);
		}
		return new ResponseEntity<>(unitsDTO,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="getMyFacilities")
	public GetAllReservationsResponse getMyFacilities(@RequestBody GetAllReservationsRequest request) {
		System.out.println("usao u ws");
		return reservationClient.getAllReservations(request);
	}
	
	@GetMapping(value="syncData/{agentId}")
	public ResponseEntity<?> syncData(@PathVariable("agentId") String agentId){
		GetSyncBaseResponse response=new GetSyncBaseResponse();
		response=reservationClient.syncBase(agentId);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/getAllFacilityTypes",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllFacilityTypes() {
		
		List<FacilityType> facilityTypes=facilityService.findAllFacilityType();
		
		return new ResponseEntity<>(facilityTypes,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllCategories",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCategories() {
		
		List<Category> cat=facilityService.findAllCategory();
		
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllfas",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllAS() {
		
		List<FacilityAS> fas=facilityService.findAllFacilityAS();
		
		return new ResponseEntity<>(fas,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAlluas",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAlluas(){
		 List<UnitAS> uas=unitService.findAllAS();
		 
		 return new ResponseEntity<>(uas,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllDestinations",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDestinations() {
//		this.facilityRepository.deleteAll();
//
//		this.unitRepository.deleteAll();

		List<Destination> destinations=destinationService.findAll();
		System.out.println("Destiacije"+destinations.size());
		return new ResponseEntity<>(destinations,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllFacilities",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFacilites() {
		
		List<AccommodationFacility> facilities=facilityRepository.findAll();
		return new ResponseEntity<>(facilities,HttpStatus.OK);
	}
	
	@PostMapping(value="addFacility")
	public ResponseEntity<?> addFacility(@RequestBody NewFacilityDTO nf){
		System.out.println("usao u c1");
		PostNewAccommodationFacilityResponse response=reservationClient.addNewFacility(nf);
		System.out.println("usao c2");
		return new ResponseEntity<Long>(response.getAccommodationFacility().getId(),HttpStatus.CREATED);
	}
	
	@PostMapping(value="/uploadImage/{id}")
	public ResponseEntity<?> uploadImage(@PathVariable("id") Long id,@RequestParam("image") MultipartFile request)throws IOException{
		System.out.println("uso");
		AccommodationFacility facility=facilityRepository.findOneByid(id);
		System.out.println("slika"+facility.getName());
		byte[] img=request.getBytes();
		facility.setImage(img);
		facilityRepository.save(facility);
		PostNewAccommodationFacilityResponse response=reservationClient.addImage(facility);
		System.out.println("usao c2");
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PostMapping(value="addUnit")
	public ResponseEntity<?> addUnit(@RequestBody NewUnitDTO nu){
		System.out.println("usao u c1"+nu.getDaysBefore());
		PostNewUnitResponse response=reservationClient.addNewUnit(nu);
		System.out.println("usao c2");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
