//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.09 at 04:33:23 AM CEST 
//


package megatravel.data.xsd;

import java.util.ArrayList;
import java.util.List;
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
public class AccommodationUnit {

    protected long id;
    protected int capacity;
    protected boolean canBeCancelled;
    protected int daysBefore;
    protected List<UnitAS> unitAS;
    @XmlElement(required = true)
    protected AccommodationFacility accommodationFacility;
    @XmlElement(required = true)
    protected String image;
    @XmlElement(required = true)
    protected PricePerMonth pricePerMonth;

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

    public void setUnitAS(List<UnitAS> unitAS) {
		this.unitAS = unitAS;
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

}
