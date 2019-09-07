package rs.ac.uns.ftn.reservation.serviceImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.Reservation;
import rs.ac.uns.ftn.reservation.model.UnitAS;
import rs.ac.uns.ftn.reservation.repository.ReservationRepository;
import rs.ac.uns.ftn.reservation.repository.UnitASRepository;
import rs.ac.uns.ftn.reservation.repository.UnitRepository;
import rs.ac.uns.ftn.reservation.service.UnitService;
@Service
public class UnitServiceImp implements UnitService{
	
	@Autowired
	UnitASRepository unitASRepository;
	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	ReservationRepository reservationReposiory;

	@Override
	public List<UnitAS> findAllAS() {
		// TODO Auto-generated method stub
		return this.unitASRepository.findAll();
	}

	@Override
	public List<AccommodationUnit> findAllUnits() {
		// TODO Auto-generated method stub
		return unitRepository.findAll();
	}

	@Override
	public List<AccommodationUnit> findUnitSByFacility(Long id) {
		// TODO Auto-generated method stub
		return unitRepository.findByAccommodationFacilityId(id);
	}

	@Override
	public List<AccommodationUnit> findAvailableUnitsInFacility(Long id,Date checkIn, Date checkOut) {
		// TODO Auto-generated method stub
		List<AccommodationUnit> availableUnits=this.unitRepository.findByAccommodationFacilityId(id);
		List<Reservation> reservations=this.reservationReposiory.findAll();
		
//		String date=new SimpleDateFormat("yyyy-MM-dd").format(checkIn);
//		try {
//			checkIn= new SimpleDateFormat("yyyy-MM-dd").parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		date=new SimpleDateFormat("yyyy-MM-dd").format(checkOut);
//		
//		try {
//			checkOut= new SimpleDateFormat("yyyy-MM-dd").parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
		
	
			//izbacivanje unit-a koji su rezervisani u datom periodu
				for(Reservation r: reservations) {
					System.out.println("1korak");
					if(availableUnits.contains(r.getAccommodationUnit())) {
						System.out.println("2 korak");
						if((r.getCheckInDate().compareTo(checkIn)>0 && r.getCheckInDate().compareTo(checkOut)<0)||
								(r.getCheckOutDate().compareTo(checkIn)>0 && r.getCheckOutDate().compareTo(checkOut)<0)){
							System.out.println("3korak");
							availableUnits.remove(r.getAccommodationUnit());
						}
					}
				}
		
		for(AccommodationUnit unit:availableUnits) {
			float tem=getPrice(checkIn, unit);
			Date daysAgo = new DateTime(checkIn).minusDays(unit.getDaysBefore()).toDate();
			int days = (int)( (checkIn.getTime() - checkOut.getTime()) / (1000 * 60 * 60 * 24));
			days=Math.abs(days);
			unit.setNumberOfDays(days);
			unit.setCancelDate(daysAgo);
			unit.setCurrentPrice(tem);
		}
		
		
		return availableUnits;
	}
	
	
	
	
//	public List<AccommodationUnit> findFrees(List<AccommodationUnit> units){
//		
//	}
	
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

	
}
