package com.rubix.farmersmarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address", schema = "public")

/**
 * @author yuga
 * @class Addresses This class used for addresses entity
 */
public class Addresses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Initialize the addressId variable
	private long addressId;
	@Column(name = "name", nullable = true)
	// Initialize the name variable
	private String name;
	@Column(name = "address", nullable = false)
	// Initialize the address variable
	private String address;
	@Column(name = "city", nullable = false)
	// Initialize the city variable
	private String city;
	@Column(name = "state", nullable = false)
	// Initialize the state variable
	private String state;
	@Column(name = "zipcode", nullable = false)
	// Initialize the zipcode variable
	private String zipCode;
	@Column(name = "friendlyname", nullable = true)
	// Initialize the friendlyname variable
	private String friendlyName;
	@Column(name = "contactnumber", nullable = true)
	// Initialize the contactnumber variable
	private String contactNumber;

	// Initialize the flag variable
	private boolean isDefault;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "ignoreUnknown = true" })

	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "profile_id", referencedColumnName = "profileId")
	private Profile profile;

	public Addresses() {

	}

	public Addresses(long addressId, String name, String address, String city, String state, String zipCode,
			String friendlyName, String contactNumber, boolean isDefault) {
		super();
		this.addressId = addressId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.friendlyName = friendlyName;
		this.contactNumber = contactNumber;
		this.isDefault = isDefault;
	}

	/**
	 * getAddressId
	 * 
	 * @return long
	 */

	public long getAddressId() {
		return addressId;
	}

	/**
	 * @param AddressId
	 */

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * getName
	 * 
	 * @return String
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getAddress
	 * 
	 * @return String
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * @param Address
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getCity
	 * 
	 * @return String
	 */

	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * getState
	 * 
	 * @return String
	 */

	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * getZipCode
	 * 
	 * @return String
	 */

	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipcode
	 */

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * getFriendlyName
	 * 
	 * @return String
	 */

	public String getFriendlyName() {
		return friendlyName;
	}

	/**
	 * @param friendlyname
	 */

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	/**
	 * getContactNumber
	 * 
	 * @return String
	 */

	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactnumber
	 */

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * getProfile
	 * 
	 * @return Profile
	 */

	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * isDefault
	 * 
	 * @return isDefault
	 */

	public boolean isDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault
	 */
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "Addresses [addressId=" + addressId + ", name=" + name + ",address=" + address + ",city=" + city
				+ ",state=" + state + ",zipCode=" + zipCode + ",friendlyName=" + friendlyName + ",contactNumber="
				+ contactNumber + ",isDefault=" + isDefault + "]";
	}

}
