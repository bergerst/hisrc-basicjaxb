package org.jvnet.jaxb2_commons.tests.simple_hashcode_equals_01.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Customer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="blueEyes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="middleInitials" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="single" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
    "address",
    "blueEyes",
    "familyName",
    "givenName",
    "middleInitials",
    "postCode",
    "single"
})
public class Customer2 {

    @XmlElement(required = true)
    protected String address;
    protected Boolean blueEyes;
    @XmlElement(required = true)
    protected String familyName;
    @XmlElement(required = true)
    protected String givenName;
    protected List<String> middleInitials;
    @XmlElement(required = true)
    protected String postCode;
    protected boolean single;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

    /**
     * Gets the value of the blueEyes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlueEyes() {
        return blueEyes;
    }

    /**
     * Sets the value of the blueEyes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlueEyes(Boolean value) {
        this.blueEyes = value;
    }

    public boolean isSetBlueEyes() {
        return (this.blueEyes!= null);
    }

    /**
     * Gets the value of the familyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the value of the familyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyName(String value) {
        this.familyName = value;
    }

    public boolean isSetFamilyName() {
        return (this.familyName!= null);
    }

    /**
     * Gets the value of the givenName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Sets the value of the givenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGivenName(String value) {
        this.givenName = value;
    }

    public boolean isSetGivenName() {
        return (this.givenName!= null);
    }

    /**
     * Gets the value of the middleInitials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the middleInitials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiddleInitials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMiddleInitials() {
        if (middleInitials == null) {
            middleInitials = new ArrayList<String>();
        }
        return this.middleInitials;
    }

    public boolean isSetMiddleInitials() {
        return ((this.middleInitials!= null)&&(!this.middleInitials.isEmpty()));
    }

    public void unsetMiddleInitials() {
        this.middleInitials = null;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    public boolean isSetPostCode() {
        return (this.postCode!= null);
    }

    /**
     * Gets the value of the single property.
     * 
     */
    public boolean isSingle() {
        return single;
    }

    /**
     * Sets the value of the single property.
     * 
     */
    public void setSingle(boolean value) {
        this.single = value;
    }

    public boolean isSetSingle() {
        return true;
    }

    public int hashCode2() {
        int currentHashCode = 1;
        {
            String theAddress;
            theAddress = this.getAddress();
            currentHashCode = ((currentHashCode* 31)+(this.isSetAddress()?theAddress.hashCode(): 0));
        }
        {
            Boolean theBlueEyes;
            theBlueEyes = this.isBlueEyes();
            currentHashCode = ((currentHashCode* 31)+(this.isSetBlueEyes()?theBlueEyes.hashCode(): 0));
        }
        {
            String theFamilyName;
            theFamilyName = this.getFamilyName();
            currentHashCode = ((currentHashCode* 31)+(this.isSetFamilyName()?theFamilyName.hashCode(): 0));
        }
        {
            String theGivenName;
            theGivenName = this.getGivenName();
            currentHashCode = ((currentHashCode* 31)+(this.isSetGivenName()?theGivenName.hashCode(): 0));
        }
        {
            List<String> theMiddleInitials;
            theMiddleInitials = (this.isSetMiddleInitials()?this.getMiddleInitials():null);
            if (this.isSetMiddleInitials()) {
                final Iterator<String> theMiddleInitialsIterator = theMiddleInitials.iterator();
                int listHashCode = 1;
                while (theMiddleInitialsIterator.hasNext()) {
                    final String theMiddleInitialsElement = theMiddleInitialsIterator.next();
                    listHashCode = ((listHashCode* 31)+((theMiddleInitialsElement!= null)?theMiddleInitialsElement.hashCode(): 0));
                }
                currentHashCode = ((currentHashCode* 31)+ listHashCode);
            } else {
                currentHashCode = (currentHashCode* 31);
            }
        }
        {
            String thePostCode;
            thePostCode = this.getPostCode();
            currentHashCode = ((currentHashCode* 31)+(this.isSetPostCode()?thePostCode.hashCode(): 0));
        }
        {
            boolean theSingle;
            theSingle = this.isSingle();
            currentHashCode = ((currentHashCode* 31)+(theSingle? 1231 : 1237));
        }
        return currentHashCode;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((blueEyes == null) ? 0 : blueEyes.hashCode());
		result = prime * result
				+ ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result
				+ ((givenName == null) ? 0 : givenName.hashCode());
		result = prime * result
				+ ((middleInitials == null) ? 0 : middleInitials.hashCode());
		result = prime * result
				+ ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + (single ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer2 other = (Customer2) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (blueEyes == null) {
			if (other.blueEyes != null)
				return false;
		} else if (!blueEyes.equals(other.blueEyes))
			return false;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		if (middleInitials == null) {
			if (other.middleInitials != null)
				return false;
		} else if (!middleInitials.equals(other.middleInitials))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (single != other.single)
			return false;
		return true;
	}
    
    

}
