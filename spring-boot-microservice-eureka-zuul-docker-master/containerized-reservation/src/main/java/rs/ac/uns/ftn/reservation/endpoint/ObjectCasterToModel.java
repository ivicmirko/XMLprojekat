package rs.ac.uns.ftn.reservation.endpoint;

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


public class ObjectCasterToModel {

	public rs.ac.uns.ftn.reservation.model.FacilityType castFacilityType(FacilityType tip) {
		rs.ac.uns.ftn.reservation.model.FacilityType facilityType = new rs.ac.uns.ftn.reservation.model.FacilityType();
		facilityType.setId(tip.getId());
		facilityType.setName(tip.getName());
		return facilityType;
	}
	
	public rs.ac.uns.ftn.reservation.model.Category castCategory(Category cat) {
		rs.ac.uns.ftn.reservation.model.Category category = new rs.ac.uns.ftn.reservation.model.Category();
		category.setName(cat.getName());
		category.setId(cat.getId());
		return category;
	}
	
	public rs.ac.uns.ftn.reservation.model.Destination castDestination(Destination des) {
		rs.ac.uns.ftn.reservation.model.Destination destination = new rs.ac.uns.ftn.reservation.model.Destination();
		destination.setName(des.getName());
		destination.setId(des.getId());
		destination.setLatitude(des.getLatitude());
		destination.setLongitude(des.getLongitude());
		return destination;
	}
	
	public rs.ac.uns.ftn.reservation.model.Location castLocation(Location loc) {
		rs.ac.uns.ftn.reservation.model.Location location = new rs.ac.uns.ftn.reservation.model.Location();
		location.setId(loc.getId());
		location.setAddress(loc.getAddress());
		location.setDescription(loc.getDescription());
		location.setLatitude(loc.getLatitude());
		location.setLongitude(loc.getLongitude());
		return location;
	}
	
	public rs.ac.uns.ftn.reservation.model.FacilityAS castFacilityAS(FacilityAS fas) {
		rs.ac.uns.ftn.reservation.model.FacilityAS facilityAS = new rs.ac.uns.ftn.reservation.model.FacilityAS();
		facilityAS.setId(fas.getId());
		facilityAS.setName(fas.getName());
		return facilityAS;
	}
	
	public rs.ac.uns.ftn.reservation.model.UnitAS castUnitAS(UnitAS uas) {
		rs.ac.uns.ftn.reservation.model.UnitAS unitAS = new rs.ac.uns.ftn.reservation.model.UnitAS();
		unitAS.setId(uas.getId());
		unitAS.setName(uas.getName());
		return unitAS;
	}
	
	public rs.ac.uns.ftn.reservation.model.PricePerMonth castPricePerMonth(PricePerMonth ppm) {
		rs.ac.uns.ftn.reservation.model.PricePerMonth pricePerMonth = new rs.ac.uns.ftn.reservation.model.PricePerMonth();
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
	
	public rs.ac.uns.ftn.reservation.model.AccommodationFacility castAccommodationFacility(AccommodationFacility acc) {
		rs.ac.uns.ftn.reservation.model.AccommodationFacility accommodation= new rs.ac.uns.ftn.reservation.model.AccommodationFacility();
		rs.ac.uns.ftn.reservation.model.FacilityType facilityType= new rs.ac.uns.ftn.reservation.model.FacilityType();
		rs.ac.uns.ftn.reservation.model.Category category=new rs.ac.uns.ftn.reservation.model.Category();
		List<rs.ac.uns.ftn.reservation.model.FacilityAS> facilityAS=new ArrayList<>(); 
		rs.ac.uns.ftn.reservation.model.Location location=new rs.ac.uns.ftn.reservation.model.Location();
		rs.ac.uns.ftn.reservation.model.Destination destination=new rs.ac.uns.ftn.reservation.model.Destination();
		
		accommodation.setId(acc.getId());
		accommodation.setAgentId(acc.getAgentId());
		accommodation.setDescription(acc.getDescription());
		accommodation.setImage(acc.getImage());
		accommodation.setName(acc.getName());
		accommodation.setRating(acc.getRating());
		accommodation.setVoters(acc.getVoters());
		System.out.println("cast1");
		facilityType.setId(acc.getFacilityType().getId());
		facilityType.setName(acc.getFacilityType().getName());
		accommodation.setFacilityType(facilityType);

		System.out.println("cast2"+acc.getCategory().getName());
		category.setId(acc.getCategory().getId());
		category.setName(acc.getCategory().getName());
		accommodation.setCategory(category);
		System.out.println("cast3");

		location.setId(acc.getLocation().getId());
		location.setAddress(acc.getLocation().getAddress());
		location.setDescription(acc.getLocation().getDescription());
		location.setLatitude(acc.getLocation().getLatitude());
		location.setLongitude(acc.getLocation().getLongitude());
		accommodation.setLocation(location);
		System.out.println("cast4");
		destination.setName(acc.getDestination().getName());
		destination.setId(acc.getDestination().getId());
		destination.setLatitude(acc.getDestination().getLatitude());
		destination.setLongitude(acc.getDestination().getLongitude());
		accommodation.setDestination(destination);
		System.out.println("cast5");

		for(FacilityAS f:acc.getFacilityAS()) {
			rs.ac.uns.ftn.reservation.model.FacilityAS fas=new rs.ac.uns.ftn.reservation.model.FacilityAS();
			fas.setId(f.getId());
			fas.setName(f.getName());
			facilityAS.add(fas);
		}
		accommodation.setFacilityAS(facilityAS);
		System.out.println("cast6");

		return accommodation;
	}
	
	public rs.ac.uns.ftn.reservation.model.AccommodationUnit castAccommodationUnit(AccommodationUnit acc) {
		rs.ac.uns.ftn.reservation.model.AccommodationUnit unit=new rs.ac.uns.ftn.reservation.model.AccommodationUnit();
		List<rs.ac.uns.ftn.reservation.model.UnitAS> uas=new ArrayList<>();
		rs.ac.uns.ftn.reservation.model.PricePerMonth ppm=new rs.ac.uns.ftn.reservation.model.PricePerMonth();
		rs.ac.uns.ftn.reservation.model.AccommodationFacility facility=new rs.ac.uns.ftn.reservation.model.AccommodationFacility();

		unit.setId(acc.getId());
		unit.setCanBeCancelled(acc.isCanBeCancelled());
		unit.setCapacity(acc.getCapacity());
		unit.setDaysBefore(acc.getDaysBefore());
		
		facility=this.castAccommodationFacility(acc.getAccommodationFacility());
		unit.setAccommodationFacility(facility);
		
		ppm=this.castPricePerMonth(acc.getPricePerMonth());
		unit.setPricePerMonth(ppm);
		
		for(UnitAS u:acc.getUnitAS()) {
			rs.ac.uns.ftn.reservation.model.UnitAS uu = new rs.ac.uns.ftn.reservation.model.UnitAS();
			uu.setId(u.getId());
			uu.setName(u.getName());
			uas.add(uu);
		}
		
		unit.setUnitAS(uas);

		return unit;
	}
	
	public rs.ac.uns.ftn.reservation.model.Reservation castReservation(Reservation res) {
		rs.ac.uns.ftn.reservation.model.Reservation reservation = new rs.ac.uns.ftn.reservation.model.Reservation();
		rs.ac.uns.ftn.reservation.model.AccommodationUnit unit= new rs.ac.uns.ftn.reservation.model.AccommodationUnit();
		
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
