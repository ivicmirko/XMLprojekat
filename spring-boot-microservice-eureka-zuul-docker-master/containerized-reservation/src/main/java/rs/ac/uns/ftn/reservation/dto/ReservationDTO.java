package rs.ac.uns.ftn.reservation.dto;

import java.util.Date;

public class ReservationDTO {
	
	private Date checkInDate;
	private Date checkOutDate;
	private Long idUnit;
	private float totalPrice;
	private String usernameGuest;
	
	public ReservationDTO() {
		
	}

	public ReservationDTO(Date checkInDate, Date checkOutDate, Long idUnit, float totalPrice, String usernameGuest) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.idUnit = idUnit;
		this.totalPrice = totalPrice;
		this.usernameGuest = usernameGuest;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Long getIdUnit() {
		return idUnit;
	}

	public void setIdUnit(Long idUnit) {
		this.idUnit = idUnit;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUsernameGuest() {
		return usernameGuest;
	}

	public void setUsernameGuest(String usernameGuest) {
		this.usernameGuest = usernameGuest;
	}
	
	


}
