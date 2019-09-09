package rs.ac.uns.ftn.agent.serviceImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.agent.repository.ReservationRepository;
import rs.ac.uns.ftn.agent.repository.UnitRepository;
import rs.ac.uns.ftn.agent.service.ReservationService;



@Service
public class ReservationServiceImp implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	UnitRepository unitRepository;
	
	
//	@Override
//	@Transactional
//	public int makeReservation(ReservationDTO dto) {
//		// TODO Auto-generated method stub
//		Date checkIn=dto.getCheckInDate();
//		Date checkOut=dto.getCheckOutDate();
//		
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
//		}
//		
//		
//		try {
//			Reservation reservation=new Reservation();
//			reservation.setCheckInDate(checkIn);
//			reservation.setCheckOutDate(checkOut);
//			reservation.setTotalPrice(dto.getTotalPrice());
//			
//			AccommodationUnit acUnit=unitRepository.findOneById(dto.getIdUnit());
//			if(acUnit ==null) {
//				return 1;
//			}
//			
//			reservation.setAccommodationUnit(acUnit);
//			reservation.setIsRealised(false);
//			
//			if(!dto.getUsernameGuest().equals("")) {
//				reservation.setGuestUserName(dto.getUsernameGuest());
//			}
//			
//			reservationRepository.save(reservation);
//			
//			return 0;
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return 1;
//		}
//	}
//
//
//	@Override
//	public List<Reservation> findReservationsByGuestUsername(String username) {
//		// TODO Auto-generated method stub
//		List<Reservation> reservations=this.reservationRepository.findByGuestUserName(username);
//		return reservations;
//	}
//
//
//	@Override
//	public Reservation cancelReservation(Long id) {
//		// TODO Auto-generated method stub
//		Reservation reservation=this.reservationRepository.findOneById(id);
//		this.reservationRepository.delete(reservation);
//		return reservation;
//	}


//	@Override
//	public Reservation realizeReservation(Long id) {
//		// TODO Auto-generated method stub
//		Reservation
//		return null;
//	}
	
	
	
	
	
	
	
	
	
}
