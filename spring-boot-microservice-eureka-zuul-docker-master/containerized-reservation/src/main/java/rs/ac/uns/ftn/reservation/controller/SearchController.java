package rs.ac.uns.ftn.reservation.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.reservation.dto.SearchFormParamsDTO;
import rs.ac.uns.ftn.reservation.model.AccommodationFacility;
import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.Category;
import rs.ac.uns.ftn.reservation.model.Destination;
import rs.ac.uns.ftn.reservation.model.FacilityAS;
import rs.ac.uns.ftn.reservation.model.FacilityType;
import rs.ac.uns.ftn.reservation.model.UnitAS;
import rs.ac.uns.ftn.reservation.repository.CategoryRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityASRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityTypeRepository;
import rs.ac.uns.ftn.reservation.repository.UnitASRepository;
import rs.ac.uns.ftn.reservation.service.DestinationService;
import rs.ac.uns.ftn.reservation.service.FacilityService;
import rs.ac.uns.ftn.reservation.service.UnitService;

@RestController
@RequestMapping("/api/src")
public class SearchController {
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private UnitASRepository unitAsRepository;
	
	@Autowired
	private FacilityASRepository facilityAsRepository;
	
	@Autowired
	private FacilityTypeRepository facilityTypeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UnitService unitService;

	@GetMapping(value="/getAllDestinations",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDestinations() {
		
		List<Destination> destinations=destinationService.findAll();
		
		return new ResponseEntity<>(destinations,HttpStatus.OK);
	}
	
	@PostMapping(value="/getFreeFacilities",
			
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<AccommodationFacility> getFreeFacilities(@RequestBody SearchFormParamsDTO sfpDTO){
		
		
		//List<AccommodationFacility> accf=this.facilityService.findByDestinationName(sfpDTO.getDestinationName());
		List<AccommodationFacility> accf=this.facilityService.searchForAvailable(sfpDTO.getDestinationName(), sfpDTO.getCheckIn(), sfpDTO.getCheckOut(), sfpDTO.getNumPersons());
		//!!!!!!!!OVDE TREBA DOPUNITI DA SE FILITRIRA PO DATUMU!!!!
//		try {
//			Thread.currentThread();
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Bioo i ="+accf.size());
		return accf;
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
	
	@DeleteMapping(value="/deleteuas/{id}")
	public ResponseEntity<?> deleteUas(@PathVariable("id") Long uas){
		
		this.unitAsRepository.deleteById(uas);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/adduas")
	public ResponseEntity<?> addUas(@RequestBody UnitAS uas){
		UnitAS unitAS=new UnitAS();
		unitAS.setAccommodationUnit(new ArrayList<AccommodationUnit>());
		unitAS.setName(uas.getName());
		unitAsRepository.saveAndFlush(unitAS);
		
		return new ResponseEntity<UnitAS>(unitAS,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletefas/{id}")
	public ResponseEntity<?> deletefas(@PathVariable("id") Long uas){
		
		this.facilityAsRepository.deleteById(uas);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/addfas")
	public ResponseEntity<?> addfas(@RequestBody FacilityAS fas){
		FacilityAS facilityAS=new FacilityAS();
		facilityAS.setAccommodationFacility(new ArrayList<AccommodationFacility>());
		facilityAS.setName(fas.getName());
		facilityAsRepository.saveAndFlush(facilityAS);
		
		return new ResponseEntity<FacilityAS>(facilityAS,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteType/{id}")
	public ResponseEntity<?> deleteType(@PathVariable("id") Long type){
		this.facilityTypeRepository.deleteById(type);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/addType")
	public ResponseEntity<?> addType(@RequestBody FacilityType type){
		FacilityType facilityType=new FacilityType();
		facilityType.setAccommodationFacility(new ArrayList<AccommodationFacility>());
		facilityType.setName(type.getName());
		facilityTypeRepository.saveAndFlush(facilityType);
		
		return new ResponseEntity<FacilityType>(facilityType,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteCategory/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long cat){
		this.categoryRepository.deleteById(cat);	
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/addCategory")
	public ResponseEntity<?> addCategory(@RequestBody Category cat){
		Category category=new Category();
		System.out.println("aaa "+cat.getName());
		category.setAccommodationFacility(new ArrayList<AccommodationFacility>());
		category.setName(cat.getName());
		categoryRepository.saveAndFlush(category);
		
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}
	
	
	
	
}
