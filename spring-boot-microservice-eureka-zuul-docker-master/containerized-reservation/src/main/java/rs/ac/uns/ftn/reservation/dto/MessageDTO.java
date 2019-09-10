package rs.ac.uns.ftn.reservation.dto;

import java.util.Date;

public class MessageDTO {

	private String text;
	private long idSender;
	private long reservationId;
	
	public MessageDTO() {
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getIdSender() {
		return idSender;
	}

	public void setIdSender(long idSender) {
		this.idSender = idSender;
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	
	
}
