//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.05 at 06:45:40 PM CEST 
//


package megatravel.data.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accommodationFacility" type="{http://megatravel/data/xsd}AccommodationFacility"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accommodationFacility"
})
@XmlRootElement(name = "PostNewAccommodationFacilityResponse")
public class PostNewAccommodationFacilityResponse {

    @XmlElement(required = true)
    protected AccommodationFacility accommodationFacility;

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

}
