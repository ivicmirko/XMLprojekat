package rs.ac.uns.ftn.reservation.service;

import java.util.ArrayList;
import java.util.List;

import megatravel.data.xsd.AccommodationFacility;
import megatravel.data.xsd.AccommodationUnit;
import megatravel.data.xsd.Category;
import megatravel.data.xsd.Destination;
import megatravel.data.xsd.FacilityAS;
import megatravel.data.xsd.FacilityType;
import megatravel.data.xsd.Location;
import megatravel.data.xsd.PricePerMonth;
import megatravel.data.xsd.Reservation;
import megatravel.data.xsd.UnitAS;




public class ObjectCaster {

	public FacilityType castFacilityType(rs.ac.uns.ftn.reservation.model.FacilityType tip) {
		FacilityType facilityType = new FacilityType();
		facilityType.setId(tip.getId());
		facilityType.setName(tip.getName());
		return facilityType;
	}
	
	public Category castCategory(rs.ac.uns.ftn.reservation.model.Category cat) {
		Category category = new Category();
		category.setName(cat.getName());
		category.setId(cat.getId());
		return category;
	}
	
	public Destination castDestination(rs.ac.uns.ftn.reservation.model.Destination des) {
		Destination destination = new Destination();
		destination.setName(des.getName());
		destination.setId(des.getId());
		destination.setLatitude(des.getLatitude());
		destination.setLongitude(des.getLongitude());
		return destination;
	}
	
	public Location castLocation(rs.ac.uns.ftn.reservation.model.Location loc) {
		Location location = new Location();
		location.setId(loc.getId());
		location.setAddress(loc.getAddress());
		location.setDescription(loc.getDescription());
		location.setLatitude(loc.getLatitude());
		location.setLongitude(loc.getLongitude());
		return location;
	}
	
	public FacilityAS castFacilityAS(rs.ac.uns.ftn.reservation.model.FacilityAS fas) {
		FacilityAS facilityAS = new FacilityAS();
		facilityAS.setId(fas.getId());
		facilityAS.setName(fas.getName());
		return facilityAS;
	}
	
	public UnitAS castUnitAS(rs.ac.uns.ftn.reservation.model.UnitAS uas) {
		UnitAS unitAS = new UnitAS();
		unitAS.setId(uas.getId());
		unitAS.setName(uas.getName());
		return unitAS;
	}
	
	public PricePerMonth castPricePerMonth(rs.ac.uns.ftn.reservation.model.PricePerMonth ppm) {
		PricePerMonth pricePerMonth = new PricePerMonth();
		pricePerMonth.setId(ppm.getId());
		pricePerMonth.setJanuary(ppm.getJanuary());
		pricePerMonth.setFebruary(ppm.getFebruary());
		pricePerMonth.setMarch(ppm.getMarch());
		pricePerMonth.setApril(ppm.getApril());
		pricePerMonth.setMay(ppm.getMay());
		pricePerMonth.setJune(ppm.getJune());
		pricePerMonth.setJuly(ppm.getJuly());
		pricePerMonth.setAugust(ppm.getAugust());
		pricePerMonth.setSeptember(ppm.getSeptember());
		pricePerMonth.setOctober(ppm.getOctober());
		pricePerMonth.setNovember(ppm.getNovember());
		pricePerMonth.setDecember(ppm.getDecember());
		return pricePerMonth;
	}
	
	public AccommodationFacility castAccommodationFacility(rs.ac.uns.ftn.reservation.model.AccommodationFacility acc) {
		AccommodationFacility accommodation= new AccommodationFacility();
		FacilityType facilityType= new FacilityType();
		Category category=new Category();
		List<FacilityAS> facilityAS=new ArrayList<>(); 
		Location location=new Location();
		Destination destination=new Destination();
		
		accommodation.setId(acc.getId());
		accommodation.setAgentId(acc.getAgentId());
		accommodation.setDescription(acc.getDescription());
		accommodation.setImage(acc.getImage());
		accommodation.setName(acc.getName());
		accommodation.setRating(acc.getRating());
		accommodation.setVoters(acc.getVoters());
		
		facilityType.setId(acc.getFacilityType().getId());
		facilityType.setName(acc.getFacilityType().getName());
		accommodation.setFacilityType(facilityType);

		category.setId(acc.getCategory().getId());
		category.setName(acc.getCategory().getName());
		accommodation.setCategory(category);
		
		location.setId(acc.getLocation().getId());
		location.setAddress(acc.getLocation().getAddress());
		location.setDescription(acc.getLocation().getDescription());
		location.setLatitude(acc.getLocation().getLatitude());
		location.setLongitude(acc.getLocation().getLongitude());
		accommodation.setLocation(location);
		
		destination.setName(acc.getDestination().getName());
		destination.setId(acc.getDestination().getId());
		destination.setLatitude(acc.getDestination().getLatitude());
		destination.setLongitude(acc.getDestination().getLongitude());
		accommodation.setDestination(destination);
		
		for(rs.ac.uns.ftn.reservation.model.FacilityAS f:acc.getFacilityAS()) {
			FacilityAS fas=new FacilityAS();
			fas.setId(f.getId());
			fas.setName(f.getName());
			facilityAS.add(fas);
		}
		accommodation.setFacilityAS(facilityAS);
		
		return accommodation;
	}
	
	public AccommodationUnit castAccommodationUnit(rs.ac.uns.ftn.reservation.model.AccommodationUnit acc) {
		AccommodationUnit unit=new AccommodationUnit();
		List<UnitAS> uas=new ArrayList<>();
		PricePerMonth ppm=new PricePerMonth();
		AccommodationFacility facility=new AccommodationFacility();

		unit.setId(acc.getId());
		unit.setCanBeCancelled(acc.isCanBeCancelled());
		unit.setCapacity(acc.getCapacity());
		unit.setDaysBefore(unit.getDaysBefore());
		
		facility=this.castAccommodationFacility(acc.getAccommodationFacility());
		unit.setAccommodationFacility(facility);
		
		ppm=this.castPricePerMonth(acc.getPricePerMonth());
		unit.setPricePerMonth(ppm);
		
		for(rs.ac.uns.ftn.reservation.model.UnitAS u:acc.getUnitAS()) {
			UnitAS uu = new UnitAS();
			uu.setId(u.getId());
			uu.setName(u.getName());
			uas.add(uu);
		}
		
		unit.setUnitAS(uas);

		return unit;
	}
	
	public Reservation castReservation(rs.ac.uns.ftn.reservation.model.Reservation res) {
		Reservation reservation = new Reservation();
		AccommodationUnit unit= new AccommodationUnit();
		
		reservation.setId(res.getId());
		reservation.setIsRealised(res.isIsRealised());
		reservation.setTotalPrice(res.getTotalPrice());
		reservation.setGuestUserName(res.getGuestUserName());
		reservation.setCheckInDate(res.getCheckInDate());
		reservation.setCheckOutDate(res.getCheckOutDate());
	
		unit=this.castAccommodationUnit(res.getAccommodationUnit());
		reservation.setAccommodationUnit(unit);
		
		return reservation;
	}
}
