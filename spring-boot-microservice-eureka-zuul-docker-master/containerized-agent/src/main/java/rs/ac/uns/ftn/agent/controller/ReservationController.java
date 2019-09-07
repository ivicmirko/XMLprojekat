package rs.ac.uns.ftn.agent.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import megatravel.data.xsd.GetAllReservationsRequest;
import megatravel.data.xsd.GetAllReservationsResponse;
import megatravel.data.xsd.GetSyncBaseRequest;
import megatravel.data.xsd.GetSyncBaseResponse;
import rs.ac.uns.ftn.soap.ReservationClient;

@RestController
@RequestMapping("/api/agent/res")
public class ReservationController {

	
	@Autowired
	ReservationClient reservationClient;
	
	
	@GetMapping(value="getAllReservations/{username}")
	public GetAllReservationsResponse getAllReservations(@PathVariable (value="username") String username) {
		System.out.println("usao u ws"+username);
		GetAllReservationsRequest req=new GetAllReservationsRequest();
		//req.setUsername(username);
		return reservationClient.getAllReservations(req);
	}
	
	@GetMapping(value="getMyFacilities")
	public GetAllReservationsResponse getMyFacilities(@RequestBody GetAllReservationsRequest request) {
		System.out.println("usao u ws");
		return reservationClient.getAllReservations(request);
	}
	
	@GetMapping(value="syncData/{agentId}")
	public ResponseEntity<?> syncData(@PathVariable("agentId") String agentId){
		GetSyncBaseResponse response=new GetSyncBaseResponse();
		response=reservationClient.syncBase(agentId);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
}
