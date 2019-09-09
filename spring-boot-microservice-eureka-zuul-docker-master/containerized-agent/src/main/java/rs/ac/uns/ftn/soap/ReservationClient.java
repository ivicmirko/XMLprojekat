package rs.ac.uns.ftn.soap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import dto.NewFacilityDTO;
import dto.NewUnitDTO;
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
import megatravel.data.xsd.PostNewAccommodationFacilityRequest;
import megatravel.data.xsd.PostNewAccommodationFacilityResponse;
import megatravel.data.xsd.PostNewUnitRequest;
import megatravel.data.xsd.PostNewUnitResponse;
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
	
	public PostNewUnitResponse addNewUnit(NewUnitDTO nu) {
		PostNewUnitRequest request=new PostNewUnitRequest();
		ObjectCaster caster=new ObjectCaster();
		ObjectCasterToXML toXml=new ObjectCasterToXML();
		
		AccommodationUnit unit=new AccommodationUnit();
		
		unit.setCapacity(nu.getCapacity());
		unit.setCanBeCancelled(nu.isCanBeCanceled());
		unit.setDaysBefore(nu.getDaysBefore());
		System.out.println(unit.getCapacity());
		
		PricePerMonth pricePerMonth=new PricePerMonth();
		pricePerMonth.setJanuary(nu.getJanuary());
		pricePerMonth.setFebruary(nu.getFebruary());
		pricePerMonth.setMarch(nu.getMarch());
		pricePerMonth.setApril(nu.getApril());
		pricePerMonth.setMay(nu.getMay());
		pricePerMonth.setJune(nu.getJune());
		pricePerMonth.setJuly(nu.getJuly());
		pricePerMonth.setAugust(nu.getAugust());
		pricePerMonth.setSeptember(nu.getSeptember());
		pricePerMonth.setOctober(nu.getOctober());
		pricePerMonth.setNovember(nu.getNovember());
		pricePerMonth.setDecember(nu.getDecember());
		
		unit.setPricePerMonth(pricePerMonth);
		
		List<UnitAS> unitASs=new ArrayList<>();
		for(long l:nu.getUnitAS()) {
			rs.ac.uns.ftn.agent.model.UnitAS uas=this.unitASRepository.findOneById(l);
			UnitAS unitAS=new UnitAS();
			unitAS.setId(uas.getId());
			unitAS.setName(uas.getName());
			unitASs.add(unitAS);
		}
		
		rs.ac.uns.ftn.agent.model.AccommodationFacility fac=new rs.ac.uns.ftn.agent.model.AccommodationFacility();
		fac=this.facilityRepository.findOneByid(nu.getFacilityId());
		AccommodationFacility facility=new AccommodationFacility();
		System.out.println("mk"+unit.getDaysBefore());
		facility=toXml.castAccommodationFacility(fac);
		
		unit.setAccommodationFacility(facility);
		
		unit.setUnitAS(unitASs);
		request.setUnit(unit);
		System.out.println("mk2"+request.getUnit().getDaysBefore());
		PostNewUnitResponse response=(PostNewUnitResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		//PostNewUnitResponse response=new PostNewUnitResponse();
		System.out.println("mk23"+response.getUnit().getDaysBefore());
		rs.ac.uns.ftn.agent.model.AccommodationUnit unitModel=caster.castAccommodationUnit(response.getUnit());
		System.out.println("mk3"+unitModel.getDaysBefore());
		this.unitRepository.save(unitModel);
		
		return response;
		
	}
	
	public PostNewAccommodationFacilityResponse addNewFacility(NewFacilityDTO nf) {
		System.out.println("eneter");
		PostNewAccommodationFacilityRequest request=new PostNewAccommodationFacilityRequest();
		
		AccommodationFacility facility=new AccommodationFacility();
		facility.setName(nf.getName());
		facility.setDescription(nf.getDescription());
		
		facility.setVoters(0);
		facility.setRating(0);
		
		Location location=new Location();
		location.setAddress(nf.getAddress());
		location.setDescription(nf.getDescriptionLocation());
		location.setLatitude(nf.getLatitude());
		location.setLongitude(nf.getLongitude());
		
		facility.setLocation(location);
		
		rs.ac.uns.ftn.agent.model.Destination des=destinationRepository.findOneById(nf.getDestinationId());
		Destination destination=new Destination();
		destination.setId(des.getId());
		destination.setLatitude(des.getLatitude());
		destination.setLongitude(des.getLongitude());
		destination.setName(des.getName());
		
		facility.setDestination(destination);
		
		rs.ac.uns.ftn.agent.model.FacilityType ft=this.facilityTypeRepository.findOneById(nf.getFacilityTypeId());
		FacilityType facilityType=new FacilityType();
		facilityType.setId(ft.getId());
		facilityType.setName(ft.getName());
		
		facility.setFacilityType(facilityType);
		
		rs.ac.uns.ftn.agent.model.Category cat=this.categoryRepository.findOneById(nf.getCategoryId());
		Category category=new Category();
		category.setId(cat.getId());
		category.setName(cat.getName());
		
		facility.setCategory(category);
		
		List<FacilityAS> facilityASs=new ArrayList<>();
		for(long l:nf.getFacilityAS()) {
			rs.ac.uns.ftn.agent.model.FacilityAS fas=this.facilityASRepository.findOneById(l);
			FacilityAS facilityAS=new FacilityAS();
			facilityAS.setId(fas.getId());
			facilityAS.setName(fas.getName());
			facilityASs.add(facilityAS);
		}
		facility.setFacilityAS(facilityASs);
		
		facility.setAgentId(nf.getAgentId());
		request.setAgentId(2);
//		facility.setId(0);
		System.out.println("Prvi"+facility.getFacilityAS().size());
		request.setAccommodationFacility(facility);
		PostNewAccommodationFacilityResponse response=(PostNewAccommodationFacilityResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		System.out.println("drugi");
		ObjectCaster caster=new ObjectCaster();
		
		rs.ac.uns.ftn.agent.model.AccommodationFacility resfac=caster.castAccommodationFacility(response.getAccommodationFacility());
		this.facilityRepository.save(resfac);
		
		return response;
	}
	
	public PostNewAccommodationFacilityResponse addImage(rs.ac.uns.ftn.agent.model.AccommodationFacility nf) {
		PostNewAccommodationFacilityRequest request=new PostNewAccommodationFacilityRequest();
		
		AccommodationFacility facility=new AccommodationFacility();
		facility.setName(nf.getName());
		facility.setDescription(nf.getDescription());
		facility.setId(nf.getId());
		
		facility.setVoters(0);
		facility.setRating(0);
		
		Location location=new Location();
		location.setAddress(nf.getLocation().getAddress());
		location.setDescription(nf.getLocation().getDescription());
		location.setLatitude(nf.getLocation().getLatitude());
		location.setLongitude(nf.getLocation().getLongitude());
		
		facility.setLocation(location);
		
		rs.ac.uns.ftn.agent.model.Destination des=nf.getDestination();
		Destination destination=new Destination();
		destination.setId(des.getId());
		destination.setLatitude(des.getLatitude());
		destination.setLongitude(des.getLongitude());
		destination.setName(des.getName());
		
		facility.setDestination(destination);
		
		rs.ac.uns.ftn.agent.model.FacilityType ft=nf.getFacilityType();
		FacilityType facilityType=new FacilityType();
		facilityType.setId(ft.getId());
		facilityType.setName(ft.getName());
		
		facility.setFacilityType(facilityType);
		
		rs.ac.uns.ftn.agent.model.Category cat=nf.getCategory();
		Category category=new Category();
		category.setId(cat.getId());
		category.setName(cat.getName());
		
		facility.setCategory(category);
		
		List<FacilityAS> facilityASs=new ArrayList<>();
		for(rs.ac.uns.ftn.agent.model.FacilityAS fas:nf.getFacilityAS()) {
			FacilityAS facilityAS=new FacilityAS();
			facilityAS.setId(fas.getId());
			facilityAS.setName(fas.getName());
			facilityASs.add(facilityAS);
		}
		facility.setFacilityAS(facilityASs);
		
		facility.setAgentId(nf.getAgentId());
		request.setAgentId(2);
		facility.setImage(nf.getImage());
		System.out.println("Prvi"+facility.getFacilityAS().size());
		request.setAccommodationFacility(facility);
		PostNewAccommodationFacilityResponse response=(PostNewAccommodationFacilityResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		System.out.println("drugi");
		ObjectCaster caster=new ObjectCaster();
		
		rs.ac.uns.ftn.agent.model.AccommodationFacility resfac=caster.castAccommodationFacility(response.getAccommodationFacility());
		this.facilityRepository.save(resfac);
		
		return response;
	}
	
	public GetSyncBaseResponse syncBase(String agentUsername) {
		System.out.println("priv");
		ObjectCaster caster=new ObjectCaster();
		GetSyncBaseRequest request=new GetSyncBaseRequest();
		request.setAgentId(2);
		System.out.println("drugi");
		GetSyncBaseResponse response=(GetSyncBaseResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		System.out.println("trece");
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
