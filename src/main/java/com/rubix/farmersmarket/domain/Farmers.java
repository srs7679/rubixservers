package com.rubix.farmersmarket.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "farmers", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "address" }))
public class Farmers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long farmerId;
	private String fullName;
	@Column(name = "address")
	private String address;
	private String pickupAddress;
	private String place;
	@Embedded
	private Deliveryfrequency deliveryfrequency;
	@OneToMany(mappedBy = "farmers", cascade = CascadeType.ALL)
	private List<Phones> phones;
	@Embedded
	private String contactperson;
	private double landareasqft;
	@ElementCollection
	private List<String> preferredlanguage;
	private Boolean isActive;
	private Boolean isPriorityUser;
	private String assignedzone;
	private int rating;
	private long closedorders;
	@Embedded
	private FarmersCreateddate createddate;
	@Embedded
	private FarmersUpdateddate updateddate;

	@OneToMany(mappedBy = "farmers", cascade = CascadeType.REMOVE)
	private List<FarmersProduct> products;

	@OneToMany(mappedBy = "farmers", cascade = CascadeType.REMOVE)
	private List<FarmersFeedback> feedback;

	@OneToMany(mappedBy = "farmers", cascade = CascadeType.REMOVE)
	private List<FarmersDeliveryqueries> deliveryqueries;

	public Farmers() {

	}

	public Farmers(long farmerId, String fullName, String address,String pickupAddress,String place, Deliveryfrequency deliveryfrequency,
			List<Phones> phones, String contactperson, double landareasqft, List<String> preferredlanguage,
			Boolean isActive, Boolean isPriorityUser, String assignedzone, int rating, long closedorders,
			FarmersCreateddate createddate, FarmersUpdateddate updateddate, List<FarmersDeliveryqueries> deliveryqueries) {
		super();
		this.farmerId = farmerId;
		this.fullName = fullName;
		this.address = address;
		this.pickupAddress=pickupAddress;
		this.place = place;
		this.deliveryfrequency = deliveryfrequency;
		this.phones = phones;
		this.contactperson = contactperson;
		this.landareasqft = landareasqft;
		this.preferredlanguage = preferredlanguage;
		this.isActive = isActive;
		this.isPriorityUser = isPriorityUser;
		this.assignedzone = assignedzone;
		this.rating = rating;
		this.closedorders = closedorders;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.deliveryqueries = deliveryqueries;
	}

	public long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(long farmerId) {
		this.farmerId = farmerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Deliveryfrequency getDeliveryfrequency() {
		return deliveryfrequency;
	}

	public void setDeliveryfrequency(Deliveryfrequency deliveryfrequency) {
		this.deliveryfrequency = deliveryfrequency;
	}

	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public double getLandareasqft() {
		return landareasqft;
	}

	public void setLandareasqft(double landareasqft) {
		this.landareasqft = landareasqft;
	}

	public List<String> getPreferredlanguage() {
		return preferredlanguage;
	}

	public void setPreferredlanguage(List<String> preferredlanguage) {
		this.preferredlanguage = preferredlanguage;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsPriorityUser() {
		return isPriorityUser;
	}

	public void setIsPriorityUser(Boolean isPriorityUser) {
		this.isPriorityUser = isPriorityUser;
	}

	public String getAssignedzone() {
		return assignedzone;
	}

	public void setAssignedzone(String assignedzone) {
		this.assignedzone = assignedzone;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getClosedorders() {
		return closedorders;
	}

	public void setClosedorders(long closedorders) {
		this.closedorders = closedorders;
	}

	public FarmersCreateddate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(FarmersCreateddate createddate) {
		this.createddate = createddate;
	}

	public FarmersUpdateddate getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(FarmersUpdateddate updateddate) {
		this.updateddate = updateddate;
	}

	public List<FarmersProduct> getProducts() {
		return products;
	}

	public void setProducts(List<FarmersProduct> products) {
		this.products = products;
	}

	public List<FarmersFeedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<FarmersFeedback> feedback) {
		this.feedback = feedback;
	}

	public List<FarmersDeliveryqueries> getDeliveryqueries() {
		return deliveryqueries;
	}

	public void setDeliveryqueries(List<FarmersDeliveryqueries> deliveryqueries) {
		this.deliveryqueries = deliveryqueries;
	}

}
