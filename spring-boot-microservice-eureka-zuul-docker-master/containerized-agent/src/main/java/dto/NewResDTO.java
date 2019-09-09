package dto;

import java.util.Date;

public class NewResDTO {
	
	private Date checkInDate;
	private Date checkOutDate;
	private float totalPrice;
	private boolean isRealized;
	private long unitId;
	
	public NewResDTO() {
		
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

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isRealized() {
		return isRealized;
	}

	public void setRealized(boolean isRealized) {
		this.isRealized = isRealized;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	
	

}
