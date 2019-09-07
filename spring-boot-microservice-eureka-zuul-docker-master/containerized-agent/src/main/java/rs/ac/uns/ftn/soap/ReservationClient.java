package rs.ac.uns.ftn.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import megatravel.data.xsd.AccommodationFacility;
import megatravel.data.xsd.AccommodationUnit;
import megatravel.data.xsd.Category;
import megatravel.data.xsd.Destination;
import megatravel.data.xsd.FacilityAS;
import megatravel.data.xsd.FacilityType;
import megatravel.data.xsd.GetAllReservationsRequest;
import megatravel.data.xsd.GetAllReservationsResponse;
import megatravel.data.xsd.GetSyncBaseRequest;
import megatravel.data.xsd.GetSyncBaseResponse;
import megatravel.data.xsd.Location;
import megatravel.data.xsd.PricePerMonth;
import megatravel.data.xsd.Reservation;
import megatravel.data.xsd.UnitAS;

import rs.ac.uns.ftn.agent.repository.CategoryRepository;
import rs.ac.uns.ftn.agent.repository.DestinationRepository;
import rs.ac.uns.ftn.agent.repository.FacilityASRepository;
import rs.ac.uns.ftn.agent.repository.FacilityRepository;
import rs.ac.uns.ftn.agent.repository.FacilityTypeRepository;
import rs.ac.uns.ftn.agent.repository.LocationRepository;
import rs.ac.uns.ftn.agent.repository.PricePerMonthRepository;
import rs.ac.uns.ftn.agent.repository.ReservationRepository;
import rs.ac.uns.ftn.agent.repository.UnitASRepository;
import rs.ac.uns.ftn.agent.repository.UnitRepository;
import rs.ac.uns.ftn.agent.service.ObjectCaster;

public class ReservationClient extends WebServiceGatewaySupport {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	FacilityTypeRepository facilityTypeRepository;
	
	@Autowired
	FacilityASRepository facilityASRepository;
	
	@Autowired
	UnitASRepository unitASRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	DestinationRepository destinationRepository;
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	PricePerMonthRepository pricePerMonthRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public GetAllReservationsResponse getAllReservations(GetAllReservationsRequest request) {
		return (GetAllReservationsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	
	public GetSyncBaseResponse syncBase(String agentUsername) {
		System.out.println("priv");
		ObjectCaster caster=new ObjectCaster();
		GetSyncBaseRequest request=new GetSyncBaseRequest();
		request.setAgentId(2);
		System.out.println("drugi");
		GetSyncBaseResponse response=(GetSyncBaseResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		
		for(Category cat : response.getCategory()) {
			rs.ac.uns.ftn.agent.model.Category category = new rs.ac.uns.ftn.agent.model.Category();
			category=caster.castCategory(cat);
			categoryRepository.save(category);
		}
		
		for(FacilityType type : response.getFacilityType()) {
			rs.ac.uns.ftn.agent.model.FacilityType facilityType = new rs.ac.uns.ftn.agent.model.FacilityType();
			facilityType=caster.castFacilityType(type);
			facilityTypeRepository.save(facilityType);
		}
		
		for(FacilityAS fas: response.getFacilityAS()) {
			rs.ac.uns.ftn.agent.model.FacilityAS facilityAS= new rs.ac.uns.ftn.agent.model.FacilityAS();
			facilityAS=caster.castFacilityAS(fas);
			facilityASRepository.save(facilityAS);
		}
		
		for(UnitAS uas: response.getUnitAS()) {
			rs.ac.uns.ftn.agent.model.UnitAS unitAS= new rs.ac.uns.ftn.agent.model.UnitAS();
			unitAS=caster.castUnitAS(uas);
			unitASRepository.save(unitAS);
		}
		
		for(Location loc:response.getLocation()) {
			rs.ac.uns.ftn.agent.model.Location location=new rs.ac.uns.ftn.agent.model.Location();
			location=caster.castLocation(loc);
			locationRepository.save(location);
		}
		
		for(Destination d:response.getDestination()) {
			rs.ac.uns.ftn.agent.model.Destination destination=new rs.ac.uns.ftn.agent.model.Destination();
			destination=caster.castDestination(d);
			destinationRepository.save(destination);
		}
		
		for(PricePerMonth p:response.getPricePerMonth()) {
			rs.ac.uns.ftn.agent.model.PricePerMonth pricePerMonth=new rs.ac.uns.ftn.agent.model.PricePerMonth();
			pricePerMonth=caster.castPricePerMonth(p);
			pricePerMonthRepository.save(pricePerMonth);
		}
		
		for(AccommodationFacility af:response.getAccommodationFacility()) {
			rs.ac.uns.ftn.agent.model.AccommodationFacility facility=new rs.ac.uns.ftn.agent.model.AccommodationFacility();
			facility=caster.castAccommodationFacility(af);
			facilityRepository.save(facility);
		}
		
		for(AccommodationUnit u: response.getAccommodationUnit()) {
			rs.ac.uns.ftn.agent.model.AccommodationUnit unit=new rs.ac.uns.ftn.agent.model.AccommodationUnit();
			unit=caster.castAccommodationUnit(u);
			unitRepository.save(unit);
		}
		
		for(Reservation r:response.getReservation()) {
			rs.ac.uns.ftn.agent.model.Reservation reservation=new rs.ac.uns.ftn.agent.model.Reservation();
			reservation=caster.castReservation(r);
			reservationRepository.save(reservation);
		}
	
		return response;
	}

}
