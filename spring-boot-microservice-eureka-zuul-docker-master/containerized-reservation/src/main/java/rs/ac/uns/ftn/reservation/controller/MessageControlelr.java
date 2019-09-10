package rs.ac.uns.ftn.reservation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.reservation.dto.MessageDTO;
import rs.ac.uns.ftn.reservation.model.Message;
import rs.ac.uns.ftn.reservation.model.Reservation;
import rs.ac.uns.ftn.reservation.repository.MessageRepository;
import rs.ac.uns.ftn.reservation.repository.ReservationRepository;

@RestController
@RequestMapping("/api/message")
public class MessageControlelr {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@PostMapping(value="/sendMessage")
	public ResponseEntity<?> sendMessage(@RequestBody MessageDTO md){
		Reservation reservation=new Reservation();
		reservation=this.reservationRepository.findOneById(md.getReservationId());
		Message message=new Message();
		message.setDate(new Date());
		message.setIdSender(md.getIdSender());
		message.setText(md.getText());
		message.setIdReceiver(reservation.getAccommodationUnit().getAccommodationFacility().getAgentId());
		this.messageRepository.save(message);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value="/respondMessage")
	public ResponseEntity<?> sendMessage(@RequestBody Message message){
		this.messageRepository.save(message);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getInbox/{id}")
	public ResponseEntity<?> getInbox(@PathVariable("id") Long id){
		List<Message> messages=new ArrayList<>();
		messages=this.messageRepository.findByIdReceiver(id);
		if(messages==null) {
			messages=new ArrayList<>();
		}
		
		return new ResponseEntity<>(messages,HttpStatus.OK);
	}
	
	@GetMapping(value="/getSent/{id}")
	public ResponseEntity<?> getSent(@PathVariable("id") long idSender){
		List<Message> messages=new ArrayList<>();
		System.out.println("usao u sent"+idSender);
		messages=this.messageRepository.findByIdSender(idSender);
		System.out.println("poslo"+messages.size());
		if(messages==null) {
			messages=new ArrayList<>();
		}
		return new ResponseEntity<>(messages,HttpStatus.OK);
	}

}
