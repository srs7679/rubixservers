package com.rubix.farmersmarket.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "phones", schema = "public")
public class Phones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long phoneId;
	private String landline;
	private String mobileno;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmerId")
	private Farmers farmers;

	public Phones() {

	}

	public Phones(long phoneId, String landline, String mobileno) {
		super();
		this.phoneId = phoneId;
		this.landline = landline;
		this.mobileno = mobileno;
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Farmers getFarmers() {
		return farmers;
	}

	public void setFarmers(Farmers farmers) {
		this.farmers = farmers;
	}

}
