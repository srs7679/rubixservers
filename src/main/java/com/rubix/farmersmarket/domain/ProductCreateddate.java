package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class ProductCreateddate {
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date createdDate;
	private long epoch;

	public ProductCreateddate() {

	}

	public ProductCreateddate(Date createdDate, long epoch) {
		super();
		this.createdDate = createdDate;
		this.epoch = epoch;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getEpoch() {
		return epoch;
	}

	public void setEpoch(long epoch) {
		this.epoch = epoch;
	}

}
