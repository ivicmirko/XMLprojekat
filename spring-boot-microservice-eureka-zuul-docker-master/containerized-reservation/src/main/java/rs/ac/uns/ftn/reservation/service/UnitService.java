package rs.ac.uns.ftn.reservation.service;

import java.util.Date;
import java.util.List;

import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.UnitAS;

public interface UnitService {
	
	List<UnitAS> findAllAS();
	List<AccommodationUnit> findAllUnits();
	List<AccommodationUnit> findUnitSByFacility(Long id);
	List<AccommodationUnit> findAvailableUnitsInFacility(Long id, Date checkIn, Date checkOut);

}
