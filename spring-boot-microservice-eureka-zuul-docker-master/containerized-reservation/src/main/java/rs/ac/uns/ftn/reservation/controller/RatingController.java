package rs.ac.uns.ftn.reservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import megatravel.data.xsd.AccommodationFacility;
import megatravel.data.xsd.Comment;
import rs.ac.uns.ftn.reservation.dto.CommentDTO;
import rs.ac.uns.ftn.reservation.dto.PublishCommentDTO;
import rs.ac.uns.ftn.reservation.dto.RatingDTO;
import rs.ac.uns.ftn.reservation.model.Reservation;
import rs.ac.uns.ftn.reservation.repository.FacilityRepository;
import rs.ac.uns.ftn.reservation.repository.ReservationRepository;

@RestController
@RequestMapping("/api/rating")
@CrossOrigin("4200")
public class RatingController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value="/sendComment")
	public ResponseEntity<?> sendComment(@RequestBody CommentDTO com){
		Reservation reservation=this.reservationRepository.findOneById(com.getReservationId());
		Comment comment=new Comment();
		Date date=new Date();
		
		String dateString=new SimpleDateFormat("yyyy-MM-dd").format(date);
		try {
			date= new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comment.setDatum(dateString);
		comment.setDate(date);
		comment.setIdUser(com.getIdUser());
		comment.setPublished(false);
		comment.setText(com.getText());
		comment.setAccommodationFacilityId(reservation.getAccommodationUnit().getAccommodationFacility().getId());
		System.out.println("kom"+comment.getDate());
		HttpEntity<Comment> request = new HttpEntity<Comment>(comment);
		String _c= this.restTemplate.postForObject("http://localhost:8140/sendComment", request, String.class); 
				System.out.println("grsa"+comment.getDate());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllComments")
	public ResponseEntity<?> getAllComents(){
		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				  "http://localhost:8141/getAllComments",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Comment>>(){});
				List<Comment> employees = response.getBody();
		
				return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@PostMapping(value="/publishComment")
	public ResponseEntity<?> publishComment(@RequestBody PublishCommentDTO dto){
		System.out.println("usooooooooooooo");
		
		System.out.println("ipak"+dto.getId()+dto.isFlag());
		HttpEntity<PublishCommentDTO> request = new HttpEntity<PublishCommentDTO>(dto);
		String _c= this.restTemplate.postForObject("http://localhost:8142/publishComment", request, String.class);
//		String response = restTemplate.postForObject(
//				"http://localhost:8412/publishComment",
//				dto, String.class);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping(value="/newRating")
	public ResponseEntity<?> newRating(@RequestBody RatingDTO rat){
		rs.ac.uns.ftn.reservation.model.AccommodationFacility facility=this.reservationRepository.findOneById(rat.getReservationId()).getAccommodationUnit().getAccommodationFacility();
		
		long rate=facility.getRating()+rat.getRate();
		long voters=facility.getVoters()+1;
		facility.setVoters(voters);
		facility.setRating(rate);
		this.facilityRepository.save(facility);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/getForFacility/{id}")
	public ResponseEntity<?> getForFacility(@PathVariable("id") Long id){
		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				  "http://localhost:8141/getAllComments",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Comment>>(){});
				List<Comment> employees = response.getBody();
				
		List<Comment> comments=new ArrayList<>();
		for(Comment c:employees) {
			if(c.getAccommodationFacilityId()==id) {
				comments.add(c);
			}
		}
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}

}
