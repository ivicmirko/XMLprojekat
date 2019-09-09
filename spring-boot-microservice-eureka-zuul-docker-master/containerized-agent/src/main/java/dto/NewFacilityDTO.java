package dto;

import org.springframework.web.multipart.MultipartFile;

public class NewFacilityDTO {
	private String name;
	private String description;
	private String address;
	private float longitude;
	private float latitude;
	private String descriptionLocation;
	private long facilityTypeId;
	private long categoryId;
	private long[] facilityAS;
	private long destinationId;
//	private MultipartFile image;
	private long agentId;
	
	public NewFacilityDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getDescriptionLocation() {
		return descriptionLocation;
	}

	public void setDescriptionLocation(String descriptionLocation) {
		this.descriptionLocation = descriptionLocation;
	}

	public long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long[] getFacilityAS() {
		return facilityAS;
	}

	public void setFacilityAS(long[] facilityAS) {
		this.facilityAS = facilityAS;
	}

	public long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}

//	public MultipartFile getImage() {
//		return image;
//	}
//
//	public void setImage(MultipartFile image) {
//		this.image = image;
//	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}
	
	
	
	

}
