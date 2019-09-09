package rs.ac.uns.ftn.agent.service;

import java.util.Date;
import java.util.List;

import rs.ac.uns.ftn.agent.model.AccommodationUnit;
import rs.ac.uns.ftn.agent.model.UnitAS;



public interface UnitService {
	
	List<UnitAS> findAllAS();
	List<AccommodationUnit> findAllUnits();
	List<AccommodationUnit> findUnitSByFacility(Long id);
	//List<AccommodationUnit> findAvailableUnitsInFacility(Long id, Date checkIn, Date checkOut);

}
