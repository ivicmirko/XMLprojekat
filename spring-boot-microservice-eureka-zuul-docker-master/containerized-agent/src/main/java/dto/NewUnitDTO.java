package dto;


public class NewUnitDTO {
	
	private int capacity;
	private boolean canBeCanceled;
	private int daysBefore;
	
    protected float january;
    protected float february;
    protected float march;
    protected float april;
    protected float may;
    protected float june;
    protected float july;
    protected float august;
    protected float september;
    protected float october;
    protected float november;
    protected float december;
    
    private long[] unitAS;
    private long facilityId;
    
    
    
    
    public long getFacilityId() {
		return facilityId;
	}


	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}


	public NewUnitDTO() {
    	
    }

    
	public long[] getUnitAS() {
		return unitAS;
	}


	public void setUnitAS(long[] unitAS) {
		this.unitAS = unitAS;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isCanBeCanceled() {
		return canBeCanceled;
	}

	public void setCanBeCanceled(boolean canBeCanceled) {
		this.canBeCanceled = canBeCanceled;
	}

	public int getDaysBefore() {
		return daysBefore;
	}

	public void setDaysBefore(int daysBefore) {
		this.daysBefore = daysBefore;
	}

	public float getJanuary() {
		return january;
	}

	public void setJanuary(float january) {
		this.january = january;
	}

	public float getFebruary() {
		return february;
	}

	public void setFebruary(float february) {
		this.february = february;
	}

	public float getMarch() {
		return march;
	}

	public void setMarch(float march) {
		this.march = march;
	}

	public float getApril() {
		return april;
	}

	public void setApril(float april) {
		this.april = april;
	}

	public float getMay() {
		return may;
	}

	public void setMay(float may) {
		this.may = may;
	}

	public float getJune() {
		return june;
	}

	public void setJune(float june) {
		this.june = june;
	}

	public float getJuly() {
		return july;
	}

	public void setJuly(float july) {
		this.july = july;
	}

	public float getAugust() {
		return august;
	}

	public void setAugust(float august) {
		this.august = august;
	}

	public float getSeptember() {
		return september;
	}

	public void setSeptember(float september) {
		this.september = september;
	}

	public float getOctober() {
		return october;
	}

	public void setOctober(float october) {
		this.october = october;
	}

	public float getNovember() {
		return november;
	}

	public void setNovember(float november) {
		this.november = november;
	}

	public float getDecember() {
		return december;
	}

	public void setDecember(float december) {
		this.december = december;
	}
    
    

}
