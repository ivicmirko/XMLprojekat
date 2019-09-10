package rs.ac.uns.ftn.agent.controller;

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

import megatravel.data.xsd.GetInboxMessagesRequest;
import megatravel.data.xsd.GetInboxMessagesResponse;
import megatravel.data.xsd.GetSentMessagesResponse;
import megatravel.data.xsd.PostNewMessageResponse;
import rs.ac.uns.ftn.agent.model.Message;
import rs.ac.uns.ftn.agent.repository.MessageRepository;
import rs.ac.uns.ftn.agent.repository.ReservationRepository;
import rs.ac.uns.ftn.soap.ReservationClient;

@RestController
@RequestMapping("/api/agent/message")
public class MessageControlelr {

	@Autowired
	ReservationClient reservationClient;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@PostMapping(value="/sendMessage")
	public ResponseEntity<?> sendMessage(@RequestBody Message md){
		System.out.println("porukica"+md.getText());
		PostNewMessageResponse response=(PostNewMessageResponse) reservationClient.sendMessage(md);
//		if(response.getMessage().equals("ok")) {
//			return new ResponseEntity<>(HttpStatus.CREATED);
//
//		}else {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//		}
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/getInbox/{id}")
	public ResponseEntity<?> getInbox(@PathVariable("id") Long id){
		List<Message> messages=new ArrayList<>();
		GetInboxMessagesResponse response=(GetInboxMessagesResponse) reservationClient.getInbox(id);
		for(megatravel.data.xsd.Message m:response.getMessages()) {
			Message message=new Message();
			message.setId(m.getId());
			message.setIdReceiver(m.getIdReceiver());
			message.setIdSender(m.getIdSender());
			message.setDate(m.getDate());
			message.setText(m.getText());
			messages.add(message);
		}
		
		return new ResponseEntity<>(messages,HttpStatus.OK);
	}
	
	@GetMapping(value="/getSent/{id}")
	public ResponseEntity<?> getSent(@PathVariable("id") Long idSender){
		List<Message> messages=new ArrayList<>();
		System.out.println("usao u sent"+idSender);
		GetSentMessagesResponse response=(GetSentMessagesResponse) reservationClient.getSent(idSender);
		for(megatravel.data.xsd.Message m:response.getMessages()) {
			Message message=new Message();
			message.setId(m.getId());
			message.setIdReceiver(m.getIdReceiver());
			message.setIdSender(m.getIdSender());
			message.setDate(m.getDate());
			message.setText(m.getText());
			messages.add(message);
		}
		return new ResponseEntity<>(messages,HttpStatus.OK);
	}

}
