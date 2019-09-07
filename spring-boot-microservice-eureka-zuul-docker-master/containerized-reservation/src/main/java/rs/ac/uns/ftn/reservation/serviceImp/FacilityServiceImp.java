package rs.ac.uns.ftn.reservation.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import rs.ac.uns.ftn.reservation.model.AccommodationFacility;
import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.Category;
import rs.ac.uns.ftn.reservation.model.FacilityAS;
import rs.ac.uns.ftn.reservation.model.FacilityType;
import rs.ac.uns.ftn.reservation.model.Reservation;
import rs.ac.uns.ftn.reservation.model.UnitAS;
import rs.ac.uns.ftn.reservation.repository.CategoryRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityASRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityRepository;
import rs.ac.uns.ftn.reservation.repository.FacilityTypeRepository;
import rs.ac.uns.ftn.reservation.repository.ReservationRepository;
import rs.ac.uns.ftn.reservation.repository.UnitASRepository;
import rs.ac.uns.ftn.reservation.repository.UnitRepository;
import rs.ac.uns.ftn.reservation.service.FacilityService;
@Service
public class FacilityServiceImp implements FacilityService {

	@Autowired
	FacilityRepository facilityRepoistory;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	FacilityASRepository fasRepository;
	
	@Autowired
	FacilityTypeRepository fTypeRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	UnitASRepository unitASrepository;

	@Override
	public List<AccommodationFacility> findByDestinationName(String name) {
		// TODO Auto-generated method stub
		return facilityRepoistory.findByDestinationName(name);
	}

	@Override
	public List<FacilityType> findAllFacilityType() {
		// TODO Auto-generated method stub
		return fTypeRepository.findAll();
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<FacilityAS> findAllFacilityAS() {
		// TODO Auto-generated method stub
		return fasRepository.findAll();
	}

	@Override
	public List<AccommodationFacility> searchForAvailable(String destination, Date checkIn, Date checkOut,
			int persons) {
		// TODO Auto-generated method stub
		//sve rezervacije svih smestaja
		List<Reservation> reservations=reservationRepository.findAll();
		//sve smestajne jedinice
		List<AccommodationUnit> allUnits=unitRepository.findAll();
		//slobodne jedinice--prazno po default
		List<AccommodationUnit> availableUnit=new ArrayList<>();
		//slobodni objekti--prazno po default
		List<AccommodationFacility> availableFacility=new ArrayList<>();
		//objekat broj osoba--gleda da li taj objekat moze za trazeni broj osoba
		HashMap<String,Integer> facper=new HashMap<>();
		//
		HashMap<String,Float> minPrice=new HashMap<>();
		
		//filtriranje po destinaciji
		for(AccommodationUnit au:allUnits) {
			if(au.getAccommodationFacility().getDestination().getName().equals(destination)) {
				availableUnit.add(au);
			}
		}
		
		//filitrira tako sto gleda sve rezervacije za odredjenu destinaciju i odbacuje one jedinice koje
		//su zauzate za dati termin
		for(Reservation r: reservations) {
			if(availableUnit.contains(r.getAccommodationUnit())) {
				if((r.getCheckInDate().compareTo(checkIn)>0 && r.getCheckInDate().compareTo(checkOut)<0)||
						(r.getCheckOutDate().compareTo(checkIn)>0 && r.getCheckOutDate().compareTo(checkOut)<0)){
						availableUnit.remove(r.getAccommodationUnit());
				}
			}
		}
		
		//provera da li za objekat jedini moze da stane trazen broj gostiju
		for(AccommodationUnit au:availableUnit) {
			if(facper.containsKey(au.getAccommodationFacility().getName())) {
				int i=facper.get(au.getAccommodationFacility().getName());
				i=i+au.getCapacity();
				facper.put(au.getAccommodationFacility().getName(), i);
			}else {
				facper.put(au.getAccommodationFacility().getName(),au.getCapacity());
			}
			
			//min cena za mesec check in 
			float f=getPrice(checkIn, au);
			if(minPrice.containsKey(au.getAccommodationFacility().getName())) {
				if(minPrice.get(au.getAccommodationFacility().getName())>f) {
					minPrice.put(au.getAccommodationFacility().getName(), f);
				}
			}else {
				minPrice.put(au.getAccommodationFacility().getName(), f);
			}
			
		}
		//odbacuje one objekte koji nemaju dovoljno mesta za potreban broj gostiju
		for(AccommodationUnit au:availableUnit) {
			if((!availableFacility.contains(au.getAccommodationFacility())) && facper.get(au.getAccommodationFacility().getName()) >= persons) {
				au.getAccommodationFacility().setMinPrice(minPrice.get(au.getAccommodationFacility().getName()));
				availableFacility.add(au.getAccommodationFacility());
			}
		}
		
		return availableFacility;
	}
	
	public float getPrice(Date checkIn,AccommodationUnit au) {

		int m=checkIn.getMonth();
		if(m==0) {
			return au.getPricePerMonth().getJanuary();
		}else if(m==1) {
			return au.getPricePerMonth().getFebruary();
		}else if(m==2) {
			return au.getPricePerMonth().getMarch();
		}else if(m==3) {
			return au.getPricePerMonth().getApril();
		}else if(m==4) {
			return au.getPricePerMonth().getMay();
		}else if(m==5) {
			return au.getPricePerMonth().getJune();
		}else if(m==6) {
			return au.getPricePerMonth().getJuly();
		}else if(m==7) {
			return au.getPricePerMonth().getAugust();
		}else if(m==8) {
			return au.getPricePerMonth().getSeptember();
		}else if(m==9) {
			return au.getPricePerMonth().getOctober();
		}else if(m==10) {
			return au.getPricePerMonth().getNovember();
		}else if(m==11) {
			return au.getPricePerMonth().getDecember();
		}else {
			return 0;
		}
	}

	@Override
	public List<UnitAS> findAll() {
		// TODO Auto-generated method stub
		return unitASrepository.findAll();
	}

	@Override
	public Optional<AccommodationFacility> findByid(Long Id) {
		// TODO Auto-generated method stub
		return facilityRepoistory.findByid(Id);
	}

	
	
}
