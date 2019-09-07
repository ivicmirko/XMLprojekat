package rs.ac.uns.ftn.admin.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2019.06.06 at 08:22:30 PM CEST 
//

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
*         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}ID"/>
*         &lt;element name="CategoryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 "id",
 "categoryName"
})

@Entity
@XmlRootElement(name = "Category")
public class Category {

	 @XmlElement(name = "id", required = true)
	 //@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	 @XmlID
	 @XmlSchemaType(name = "id")
	 @Id
	 @Column(name="id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 protected Long id;
	 
	 @XmlElement(name = "CategoryName", required = true)
	 @Column(name="categoryname",nullable=false)
	 protected String name;
	 

 
	 
	 
 

	 public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}

	
	 /**
	  * Gets the value of the categoryName property.
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
	  * Sets the value of the categoryName property.
	  * 
	  * @param value
	  *     allowed object is
	  *     {@link String }
	  *     
	  */
	 public void setName(String value) {
	     this.name = value;
	 }

}

