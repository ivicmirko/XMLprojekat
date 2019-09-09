//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.02 at 06:35:03 PM CEST 
//


package rs.ac.uns.ftn.agent.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Java class for Reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="checkInDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="checkOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="isRealised" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="accommodationUnit" type="{http://megatravel/data/xsd}AccommodationUnit"/>
 *         &lt;element name="guestUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recension" type="{http://megatravel/data/xsd}recension"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservation", propOrder = {
    "id",
    "checkInDate",
    "checkOutDate",
    "totalPrice",
    "isRealised",
    "accommodationUnit",
    "guestUserName",
    "recension"
})
@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;
	
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    @Column(nullable=false)
    protected Date checkInDate;
    
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    @Column(nullable=false)
    protected Date checkOutDate;
    
    @Column
    protected float totalPrice;
    
    @XmlElement(defaultValue = "false")
    @Column
    protected boolean isRealised;
    
    @XmlElement(required = true)
    @ManyToOne
	@JoinColumn(name="accommodationUnit", nullable=false)
    @JsonIgnore
    protected AccommodationUnit accommodationUnit;
    
    @XmlElement(required = true)
    @Column
    protected String guestUserName;
    
    @Transient
    protected String facilityName;
    
//    @XmlElement(required = true)
//    protected Recension recension;

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
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
//    public XMLGregorianCalendar getCheckInDate() {
//        return checkInDate;
//    }
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
//    public void setCheckInDate(XMLGregorianCalendar value) {
//        this.checkInDate = value;
//    }
    public void setCheckInDate(Date value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
//    public XMLGregorianCalendar getCheckOutDate() {
//        return checkOutDate;
//    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
//    public void setCheckOutDate(XMLGregorianCalendar value) {
//        this.checkOutDate = value;
//    }
    public void setCheckOutDate(Date value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     */
    public void setTotalPrice(float value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the isRealised property.
     * 
     */
    public boolean isIsRealised() {
        return isRealised;
    }

    /**
     * Sets the value of the isRealised property.
     * 
     */
    public void setIsRealised(boolean value) {
        this.isRealised = value;
    }

    /**
     * Gets the value of the accommodationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationUnit }
     *     
     */
    public AccommodationUnit getAccommodationUnit() {
        return accommodationUnit;
    }

    /**
     * Sets the value of the accommodationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationUnit }
     *     
     */
    public void setAccommodationUnit(AccommodationUnit value) {
        this.accommodationUnit = value;
    }

    /**
     * Gets the value of the guestUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestUserName() {
        return guestUserName;
    }

    /**
     * Sets the value of the guestUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestUserName(String value) {
        this.guestUserName = value;
    }

	public boolean isRealised() {
		return isRealised;
	}

	public void setRealised(boolean isRealised) {
		this.isRealised = isRealised;
	}

	public String getFacilityName() {
		return this.accommodationUnit.getAccommodationFacility().getName();
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

    /**
     * Gets the value of the recension property.
     * 
     * @return
     *     possible object is
     *     {@link Recension }
     *     
     */
//    public Recension getRecension() {
//        return recension;
//    }
//
//    /**
//     * Sets the value of the recension property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link Recension }
//     *     
//     */
//    public void setRecension(Recension value) {
//        this.recension = value;
    //}

    
}
