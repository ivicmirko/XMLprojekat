package rs.ac.uns.ftn.reservation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.reservation.model.AccommodationFacility;
import rs.ac.uns.ftn.reservation.model.Category;
import rs.ac.uns.ftn.reservation.model.FacilityAS;
import rs.ac.uns.ftn.reservation.model.FacilityType;
import rs.ac.uns.ftn.reservation.model.UnitAS;

public interface FacilityService {

	List<AccommodationFacility> findByDestinationName(String name);
	List<FacilityType> findAllFacilityType();
	List<Category> findAllCategory();
	List<FacilityAS> findAllFacilityAS();
	List<AccommodationFacility> searchForAvailable(String destination,Date checkIn, Date checkOut, int persons);
	List<UnitAS> findAll();
	Optional<AccommodationFacility> findByid(Long Id);
}
