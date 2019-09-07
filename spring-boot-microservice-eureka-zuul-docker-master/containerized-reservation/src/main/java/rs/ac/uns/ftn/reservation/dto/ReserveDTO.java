package rs.ac.uns.ftn.reservation.dto;

import java.util.Date;

public class ReserveDTO {

	private Long id;
	private Date checkIn;
	private Date checkOut;
	private String status;
	private float totalPrice;
	private Long idJedinica;
	private String usernameGuest;
	
	public ReserveDTO() {
		
	}
	
	

	public float getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdJedinica() {
		return idJedinica;
	}

	public void setIdJedinica(Long idJedinica) {
		this.idJedinica = idJedinica;
	}

	public String getUsernameGuest() {
		return usernameGuest;
	}

	public void setUsernameGuest(String usernameGuest) {
		this.usernameGuest = usernameGuest;
	}
	
	
}
