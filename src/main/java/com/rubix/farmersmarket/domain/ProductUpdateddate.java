package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class ProductUpdateddate {
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date updatedDate;
	@Embedded
	private ProductEpoch epoch;

	public ProductUpdateddate() {

	}

	public ProductUpdateddate(Date updatedDate, ProductEpoch epoch) {
		super();
		this.updatedDate = updatedDate;
		this.epoch = epoch;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public ProductEpoch getEpoch() {
		return epoch;
	}

	public void setEpoch(ProductEpoch epoch) {
		this.epoch = epoch;
	}

}
