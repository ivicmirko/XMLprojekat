package rs.ac.uns.ftn.reservation.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rs.ac.uns.ftn.reservation.model.AccommodationUnit;
import rs.ac.uns.ftn.reservation.model.Category;
import rs.ac.uns.ftn.reservation.model.Destination;
import rs.ac.uns.ftn.reservation.model.FacilityAS;
import rs.ac.uns.ftn.reservation.model.FacilityType;
import rs.ac.uns.ftn.reservation.model.Location;

public class SearchFacilityResult {
	
	 protected Long id;
	 
	 protected String nameOfFacility;

	 protected String description;

	 protected String images;
	 
	 protected float rating;
	 
	 protected float voters;
	 
	 protected Location location;
	 
	 protected List<FacilityAS> facilityAS;
	 
	 protected FacilityType facilityType;
	 
	 protected Category category;
	 
	 protected Destination destination;
	 
	 protected int minPrice;
	 
	 public SearchFacilityResult() {
		 
	 }

	public SearchFacilityResult(Long id, String nameOfFacility, String description, String images, float rating,
			float voters, Location location, List<FacilityAS> facilityAS, FacilityType facilityType, Category category,
			Destination destination, int minPrice) {
		super();
		this.id = id;
		this.nameOfFacility = nameOfFacility;
		this.description = description;
		this.images = images;
		this.rating = rating;
		this.voters = voters;
		this.location = location;
		this.facilityAS = facilityAS;
		this.facilityType = facilityType;
		this.category = category;
		this.destination = destination;
		this.minPrice = minPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameOfFacility() {
		return nameOfFacility;
	}

	public void setNameOfFacility(String nameOfFacility) {
		this.nameOfFacility = nameOfFacility;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getVoters() {
		return voters;
	}

	public void setVoters(float voters) {
		this.voters = voters;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<FacilityAS> getFacilityAS() {
		return facilityAS;
	}

	public void setFacilityAS(List<FacilityAS> facilityAS) {
		this.facilityAS = facilityAS;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	 
	 
	 

}
