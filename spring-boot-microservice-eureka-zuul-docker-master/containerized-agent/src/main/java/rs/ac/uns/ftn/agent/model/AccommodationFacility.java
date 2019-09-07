//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.02 at 04:22:10 PM CEST 
//


package rs.ac.uns.ftn.agent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Java class for AccommodationFacility complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccommodationFacility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="voters" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="location" type="{http://megatravel/data/xsd}Location"/>
 *         &lt;element name="facilityAS" type="{http://megatravel/data/xsd}FacilityAS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="facilityType" type="{http://megatravel/data/xsd}FacilityType"/>
 *         &lt;element name="category" type="{http://megatravel/data/xsd}Category"/>
 *         &lt;element name="destination" type="{http://megatravel/data/xsd}Destination"/>
 *         &lt;element name="agentId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccommodationFacility", propOrder = {
    "id",
    "name",
    "description",
    "image",
    "rating",
    "voters",
    "location",
    "facilityAS",
    "facilityType",
    "category",
    "destination",
    "agentId"
})
@Entity
@Table(name="AccommodationFacility")
public class AccommodationFacility {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;
	
    @XmlElement(required = true)
    @Column(nullable=false)
    protected String name;
    
    @XmlElement(required = true)
    @Column
    protected String description;
    
    @XmlElement(required = true)
    @Lob
    @Column
    protected byte[] image;
    
    @XmlElement(defaultValue = "0")
    @Column(nullable=false)
    protected long rating;
    
    @XmlElement(defaultValue = "0")
    @Column(nullable=false)
    protected long voters;
    
    @XmlElement(required = true)
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="locationId", referencedColumnName="id")
    protected Location location;
    
    @ManyToMany
    @JoinTable(
    		name="accFacilityAS",
    		joinColumns=@JoinColumn(name="accFacilityId"),
    		inverseJoinColumns=@JoinColumn(name="asfId"))
    protected List<FacilityAS> facilityAS;
    
    @XmlElement(required = true)
    @ManyToOne
	@JoinColumn(name="facilityTypeId", nullable=false)
    protected FacilityType facilityType;
    
    @XmlElement(required = true)
    @ManyToOne
	@JoinColumn(name="category",nullable=false)
    protected Category category;
    
    @XmlElement(required = true)
    @ManyToOne
	@JoinColumn(name="destination",nullable=false)
    protected Destination destination;
    
    @Column(nullable=false)
    protected long agentId;
    
    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="accommodationFacility")
	@JsonIgnore
	protected List<AccommodationUnit> accommodationUnit;
    
    
    
    @Transient
	 protected float minPrice;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage(byte[] value) {
        this.image = ((byte[]) value);
    }

    /**
     * Gets the value of the rating property.
     * 
     */
    public long getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     */
    public void setRating(long value) {
        this.rating = value;
    }

    /**
     * Gets the value of the voters property.
     * 
     */
    public long getVoters() {
        return voters;
    }

    /**
     * Sets the value of the voters property.
     * 
     */
    public void setVoters(long value) {
        this.voters = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the facilityAS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facilityAS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacilityAS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacilityAS }
     * 
     * 
     */
    public List<FacilityAS> getFacilityAS() {
        if (facilityAS == null) {
            facilityAS = new ArrayList<FacilityAS>();
        }
        return this.facilityAS;
    }

    /**
     * Gets the value of the facilityType property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getFacilityType() {
        return facilityType;
    }

    /**
     * Sets the value of the facilityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setFacilityType(FacilityType value) {
        this.facilityType = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCategory(Category value) {
        this.category = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link Destination }
     *     
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Destination }
     *     
     */
    public void setDestination(Destination value) {
        this.destination = value;
    }

    /**
     * Gets the value of the agentId property.
     * 
     */
    public long getAgentId() {
        return agentId;
    }

    /**
     * Sets the value of the agentId property.
     * 
     */
    public void setAgentId(long value) {
        this.agentId = value;
    }

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public void setFacilityAS(List<FacilityAS> facilityAS) {
		this.facilityAS = facilityAS;
	}

	public List<AccommodationUnit> getAccommodationUnit() {
		return accommodationUnit;
	}

	public void setAccommodationUnit(List<AccommodationUnit> accommodationUnit) {
		this.accommodationUnit = accommodationUnit;
	}

	
    
}
