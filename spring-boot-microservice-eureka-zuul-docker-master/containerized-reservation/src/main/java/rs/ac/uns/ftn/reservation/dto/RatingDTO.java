package rs.ac.uns.ftn.reservation.dto;

public class RatingDTO {
	
	private Long reservationId;
	private Long rate;
	
	public RatingDTO() {
		
	}

	

	public Long getReservationId() {
		return reservationId;
	}



	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}



	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	
}
