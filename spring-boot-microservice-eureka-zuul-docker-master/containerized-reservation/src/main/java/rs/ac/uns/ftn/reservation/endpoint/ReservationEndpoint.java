package rs.ac.uns.ftn.reservation.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import megatravel.data.xsd.GetAllReservationsRequest;
import megatravel.data.xsd.GetAllReservationsResponse;
import megatravel.data.xsd.GetSyncBaseRequest;
import megatravel.data.xsd.GetSyncBaseResponse;
import megatravel.data.xsd.PostNewAccommodationFacilityRequest;
import megatravel.data.xsd.PostNewAccommodationFacilityResponse;
import megatravel.data.xsd.PostNewReservationRequest;
import megatravel.data.xsd.PostNewUnitRequest;
import megatravel.data.xsd.PostNewUnitResponse;
import megatravel.data.xsd.PostReservationRealizationRequest;
import megatravel.data.xsd.PostReservationRealizationResponse;
import rs.ac.uns.ftn.reservation.model.AccommodationFacility;
import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.Category;
import rs.ac.uns.ftn.reservation.model.Destination;
import rs.ac.uns.ftn.reservation.model.FacilityAS;
import rs.ac.uns.ftn.reservation.model.FacilityType;
import rs.ac.uns.ftn.reservation.model.Location;
import rs.ac.uns.ftn.reservation.model.PricePerMonth;
import rs.ac.uns.ftn.reservation.model.Reservation;
import rs.ac.uns.ftn.reservation.model.UnitAS;
import rs.ac.uns.ftn.reservation.repository.CategoryRepository;
import rs.ac.uns.ftn.reservation.repository.DestinationRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityASRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityTypeRepository;
import rs.ac.uns.ftn.reservation.repository.LocationRepository;
import rs.ac.uns.ftn.reservation.repository.PricePerMonthRepository;
import rs.ac.uns.ftn.reservation.repository.ReservationRepository;
import rs.ac.uns.ftn.reservation.repository.UnitASRepository;
import rs.ac.uns.ftn.reservation.repository.UnitRepository;
import rs.ac.uns.ftn.reservation.service.ObjectCaster;
import rs.ac.uns.ftn.reservation.service.ReservationService;

@Endpoint
public class ReservationEndpoint {

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
	
	@Autowired
	ReservationService reservationService;
	
	@PayloadRoot(namespace="http://megatravel/data/xsd", localPart="GetAllReservationsRequest")
	@ResponsePayload
	@Transactional
	public GetAllReservationsResponse getAllReservations(@RequestPayload GetAllReservationsRequest request) {
		List<Reservation> reservations=reservationRepository.findAll();
		
		GetAllReservationsResponse response=new GetAllReservationsResponse();
		List<megatravel.data.xsd.Reservation> retRes=new ArrayList<>();
		for(Reservation r :reservations) {
			if(r.getAccommodationUnit().getAccommodationFacility().getAgentId() == request.getAgentId()) {
				megatravel.data.xsd.Reservation res=new megatravel.data.xsd.Reservation();
				res.setId(r.getId());
//				res.setCheckInDate(r.getCheckInDate());
//				res.setCheckOutDate(r.getCheckOutDate());
				res.setGuestUserName(r.getGuestUserName());
				res.setIsRealised(r.isRealised());
				res.setTotalPrice(r.getTotalPrice());
				res.setAccommodationUnit(null);
				retRes.add(res);
			}
			
		}
		
		//response.setFacilityName();
		return response;
	
	}
	
//	@PayloadRoot(namespace="http://megatravel/data/xsd", localPart="PostNewReservationsRequest")
//	@ResponsePayload
//	public PostNewReservationResponse makeReservation(@RequestPayload PostNewReservationRequest request) {
//		ObjectCasterToModel toModel=new ObjectCasterToModel();
//		ObjectCaster toXml=new ObjectCaster();
//		
//		Reservation reservation=new Reservation();
//		reservation=toModel.castReservation(request.getReservation());
//		
//		this.reservationService.
//		
//	}
	
	
	@PayloadRoot(namespace="http://megatravel/data/xsd", localPart="PostReservationRealizationRequest")
	@ResponsePayload
	@Transactional
	public PostReservationRealizationResponse makeReservation(@RequestPayload PostReservationRealizationRequest request) {
		Reservation reservation=new Reservation();
		reservation=this.reservationRepository.findOneById(request.getReservationId());
		reservation.setIsRealised(true);
		reservation.setRealised(true);
		Reservation r=this.reservationRepository.save(reservation);
		PostReservationRealizationResponse response=new PostReservationRealizationResponse();
		String res=Long.toString(r.getId());
		response.setMessage(res);
		
		return response;
	}
	
	@PayloadRoot(namespace="http://megatravel/data/xsd", localPart="GetSyncBaseRequest")
	@ResponsePayload
	@Transactional
	public GetSyncBaseResponse getSyncBase(@RequestPayload GetSyncBaseRequest request) {
		System.out.println("Usao u ws kod res");
		GetSyncBaseResponse response=new GetSyncBaseResponse();
		ObjectCaster caster= new ObjectCaster();
//		this.unitRepository.deleteAll();
//		this.facilityRepository.deleteAll();

		List<FacilityType> types=facilityTypeRepository.findAll();
		List<Category> categories=categoryRepository.findAll();
		List<UnitAS> unitASs=unitASRepository.findAll();
		List<FacilityAS> facilityASs=facilityASRepository.findAll();
		List<Location> locations=locationRepository.findAll();
		List<Destination> destinations=destinationRepository.findAll();
		List<PricePerMonth> ppms=pricePerMonthRepository.findAll();
		List<AccommodationFacility> facilitys=facilityRepository.findAll();
		List<AccommodationUnit> units=unitRepository.findAll();
		List<Reservation> reservations=reservationRepository.findAll();
		System.out.println("sync1");
		for(Category cat : categories) {
			megatravel.data.xsd.Category category = new megatravel.data.xsd.Category();
			category=caster.castCategory(cat);
			response.getCategory().add(category);
		}
		System.out.println("sync2");

		for(FacilityType type : types) {
			megatravel.data.xsd.FacilityType facilityType = new megatravel.data.xsd.FacilityType();
			facilityType=caster.castFacilityType(type);
			response.getFacilityType().add(facilityType);
		}
		System.out.println("sync3");

		for(FacilityAS fas: facilityASs) {
			megatravel.data.xsd.FacilityAS facilityAS= new megatravel.data.xsd.FacilityAS();
			facilityAS=caster.castFacilityAS(fas);
			response.getFacilityAS().add(facilityAS);
		}
		System.out.println("sync4");

		for(UnitAS uas:unitASs ) {
			megatravel.data.xsd.UnitAS unitAS= new megatravel.data.xsd.UnitAS();
			unitAS=caster.castUnitAS(uas);
			response.getUnitAS().add(unitAS);
		}
		System.out.println("sync5");

		for(Location loc:locations) {
			megatravel.data.xsd.Location location=new megatravel.data.xsd.Location();
			location=caster.castLocation(loc);
			response.getLocation().add(location);
		}
		System.out.println("sync6");

		for(Destination d:destinations) {
			megatravel.data.xsd.Destination destination=new megatravel.data.xsd.Destination();
			destination=caster.castDestination(d);
			response.getDestination().add(destination);
		}
		System.out.println("sync7");

		for(PricePerMonth p:ppms) {
			megatravel.data.xsd.PricePerMonth pricePerMonth=new megatravel.data.xsd.PricePerMonth();
			pricePerMonth=caster.castPricePerMonth(p);
			response.getPricePerMonth().add(pricePerMonth);
		}
		System.out.println("sync8");

		for(AccommodationFacility af:facilitys) {
			megatravel.data.xsd.AccommodationFacility facility=new megatravel.data.xsd.AccommodationFacility();
			facility=caster.castAccommodationFacility(af);
			response.getAccommodationFacility().add(facility);
		}
		System.out.println("sync9");

		for(AccommodationUnit u: units) {
			megatravel.data.xsd.AccommodationUnit unit=new megatravel.data.xsd.AccommodationUnit();
			unit=caster.castAccommodationUnit(u);
			response.getAccommodationUnit().add(unit);
		}
		System.out.println("sync10");

		for(Reservation r:reservations) {
			megatravel.data.xsd.Reservation reservation=new megatravel.data.xsd.Reservation();
			reservation=caster.castReservation(r);
			response.getReservation().add(reservation);
		}
		System.out.println(response.getAccommodationFacility().get(0).getName()+"aaaaahaj");
		
		return response;
	}
	
	@PayloadRoot(namespace="http://megatravel/data/xsd", localPart="PostNewUnitRequest")
	@ResponsePayload
	@Transactional
	public PostNewUnitResponse postNewUnit(@RequestPayload PostNewUnitRequest request) {
		System.out.println("usao u unit add"+request.getUnit().getDaysBefore());
		ObjectCasterToModel toModel=new ObjectCasterToModel();
		ObjectCaster toXml=new ObjectCaster();
		
		AccommodationUnit unit=new AccommodationUnit();
		System.out.println("u1");
		unit=toModel.castAccommodationUnit(request.getUnit());
		System.out.println("u2"+unit.getDaysBefore());
		AccommodationUnit uu=this.unitRepository.save(unit);
		System.out.println("u3");
		PostNewUnitResponse response=new PostNewUnitResponse();
		response.setUnit(toXml.castAccommodationUnit(uu));
		return response;
	}
	
	@PayloadRoot(namespace="http://megatravel/data/xsd", localPart="PostNewAccommodationFacilityRequest")
	@ResponsePayload
	@Transactional
	public PostNewAccommodationFacilityResponse postNewAccommodation(@RequestPayload PostNewAccommodationFacilityRequest request) {
		ObjectCasterToModel caster=new ObjectCasterToModel();
		ObjectCaster caster2=new ObjectCaster();
		AccommodationFacility facility=new AccommodationFacility();
		facility=caster.castAccommodationFacility(request.getAccommodationFacility());

		AccommodationFacility af=this.facilityRepository.save(facility);
		PostNewAccommodationFacilityResponse response=new PostNewAccommodationFacilityResponse();
		response.setAccommodationFacility(caster2.castAccommodationFacility(af));
		
		return response;
	
	}
	

	
}
