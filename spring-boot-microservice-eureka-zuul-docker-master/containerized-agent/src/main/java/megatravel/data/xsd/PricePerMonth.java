//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.09 at 04:33:23 AM CEST 
//


package megatravel.data.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PricePerMonth complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PricePerMonth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="january" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="february" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="march" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="april" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="may" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="june" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="july" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="august" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="september" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="october" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="november" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="december" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PricePerMonth", propOrder = {
    "id",
    "january",
    "february",
    "march",
    "april",
    "may",
    "june",
    "july",
    "august",
    "september",
    "october",
    "november",
    "december"
})
public class PricePerMonth {

    protected long id;
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
     * Gets the value of the january property.
     * 
     */
    public float getJanuary() {
        return january;
    }

    /**
     * Sets the value of the january property.
     * 
     */
    public void setJanuary(float value) {
        this.january = value;
    }

    /**
     * Gets the value of the february property.
     * 
     */
    public float getFebruary() {
        return february;
    }

    /**
     * Sets the value of the february property.
     * 
     */
    public void setFebruary(float value) {
        this.february = value;
    }

    /**
     * Gets the value of the march property.
     * 
     */
    public float getMarch() {
        return march;
    }

    /**
     * Sets the value of the march property.
     * 
     */
    public void setMarch(float value) {
        this.march = value;
    }

    /**
     * Gets the value of the april property.
     * 
     */
    public float getApril() {
        return april;
    }

    /**
     * Sets the value of the april property.
     * 
     */
    public void setApril(float value) {
        this.april = value;
    }

    /**
     * Gets the value of the may property.
     * 
     */
    public float getMay() {
        return may;
    }

    /**
     * Sets the value of the may property.
     * 
     */
    public void setMay(float value) {
        this.may = value;
    }

    /**
     * Gets the value of the june property.
     * 
     */
    public float getJune() {
        return june;
    }

    /**
     * Sets the value of the june property.
     * 
     */
    public void setJune(float value) {
        this.june = value;
    }

    /**
     * Gets the value of the july property.
     * 
     */
    public float getJuly() {
        return july;
    }

    /**
     * Sets the value of the july property.
     * 
     */
    public void setJuly(float value) {
        this.july = value;
    }

    /**
     * Gets the value of the august property.
     * 
     */
    public float getAugust() {
        return august;
    }

    /**
     * Sets the value of the august property.
     * 
     */
    public void setAugust(float value) {
        this.august = value;
    }

    /**
     * Gets the value of the september property.
     * 
     */
    public float getSeptember() {
        return september;
    }

    /**
     * Sets the value of the september property.
     * 
     */
    public void setSeptember(float value) {
        this.september = value;
    }

    /**
     * Gets the value of the october property.
     * 
     */
    public float getOctober() {
        return october;
    }

    /**
     * Sets the value of the october property.
     * 
     */
    public void setOctober(float value) {
        this.october = value;
    }

    /**
     * Gets the value of the november property.
     * 
     */
    public float getNovember() {
        return november;
    }

    /**
     * Sets the value of the november property.
     * 
     */
    public void setNovember(float value) {
        this.november = value;
    }

    /**
     * Gets the value of the december property.
     * 
     */
    public float getDecember() {
        return december;
    }

    /**
     * Sets the value of the december property.
     * 
     */
    public void setDecember(float value) {
        this.december = value;
    }

}
