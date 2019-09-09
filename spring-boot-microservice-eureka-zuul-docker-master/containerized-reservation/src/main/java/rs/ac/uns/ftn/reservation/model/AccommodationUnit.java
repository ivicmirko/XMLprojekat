//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.02 at 04:22:10 PM CEST 
//


package rs.ac.uns.ftn.reservation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccommodationUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccommodationUnit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="canBeCancelled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="daysBefore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unitAS" type="{http://megatravel/data/xsd}UnitAS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accommodationFacility" type="{http://megatravel/data/xsd}AccommodationFacility"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pricePerMonth" type="{http://megatravel/data/xsd}PricePerMonth"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccommodationUnit", propOrder = {
    "id",
    "capacity",
    "canBeCancelled",
    "daysBefore",
    "unitAS",
    "accommodationFacility",
    "image",
    "pricePerMonth"
})
@Entity
@Table(name="accommodationUnit")
public class AccommodationUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;
	
	@Column(nullable=false)
    protected int capacity;
	
	@Column
    protected boolean canBeCancelled;
    
	@Column
	protected int daysBefore;
    
	@ManyToMany
 	@JoinTable(
 			name="accUnitAS",
 			joinColumns=@JoinColumn(name="accUnitId"),
 			inverseJoinColumns=@JoinColumn(name="asId"))
	protected List<UnitAS> unitAS;
    
	@XmlElement(required = true)
	@ManyToOne
 	@JoinColumn(name="accommodationFacility", nullable=false)
    protected AccommodationFacility accommodationFacility;
    
	@XmlElement(required = true)
    protected String image;
    
	@XmlElement(required = true)
	@OneToOne(cascade=CascadeType.ALL)
 	@JoinColumn(name="pricePerMonthId", referencedColumnName="id")
	protected PricePerMonth pricePerMonth;
	
	@Transient
	 private float currentPrice;
	 
	 @Transient
	 private Date cancelDate;
	 
	 @Transient
	 private int numberOfDays;

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
     * Gets the value of the capacity property.
     * 
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     */
    public void setCapacity(int value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the canBeCancelled property.
     * 
     */
    public boolean isCanBeCancelled() {
        return canBeCancelled;
    }

    /**
     * Sets the value of the canBeCancelled property.
     * 
     */
    public void setCanBeCancelled(boolean value) {
        this.canBeCancelled = value;
    }

    /**
     * Gets the value of the daysBefore property.
     * 
     */
    public int getDaysBefore() {
        return daysBefore;
    }

    /**
     * Sets the value of the daysBefore property.
     * 
     */
    public void setDaysBefore(int value) {
        this.daysBefore = value;
    }

    /**
     * Gets the value of the unitAS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unitAS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnitAS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnitAS }
     * 
     * 
     */
    public List<UnitAS> getUnitAS() {
        if (unitAS == null) {
            unitAS = new ArrayList<UnitAS>();
        }
        return this.unitAS;
    }

    /**
     * Gets the value of the accommodationFacility property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationFacility }
     *     
     */
    public AccommodationFacility getAccommodationFacility() {
        return accommodationFacility;
    }

    /**
     * Sets the value of the accommodationFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationFacility }
     *     
     */
    public void setAccommodationFacility(AccommodationFacility value) {
        this.accommodationFacility = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the pricePerMonth property.
     * 
     * @return
     *     possible object is
     *     {@link PricePerMonth }
     *     
     */
    public PricePerMonth getPricePerMonth() {
        return pricePerMonth;
    }

    /**
     * Sets the value of the pricePerMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link PricePerMonth }
     *     
     */
    public void setPricePerMonth(PricePerMonth value) {
        this.pricePerMonth = value;
    }

	public void setUnitAS(List<UnitAS> unitAS) {
		this.unitAS = unitAS;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
    
	
    

}
