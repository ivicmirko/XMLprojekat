package rs.ac.uns.ftn.reservation.dto;

import java.util.Date;

public class SearchFormParamsDTO {

	private String destinationName;
	private Date checkIn;
	private Date checkOut;
	private int numRooms;
	private int numPersons;
	
	public SearchFormParamsDTO() {
		
	}
	
	

	public SearchFormParamsDTO(String destinationName, Date checkIn, Date checkOut, int numRooms, int numPersons) {
		super();
		this.destinationName = destinationName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numRooms = numRooms;
		this.numPersons = numPersons;
	}



	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}

	public int getNumPersons() {
		return numPersons;
	}

	public void setNumPersons(int numPersons) {
		this.numPersons = numPersons;
	}
	
	
}
