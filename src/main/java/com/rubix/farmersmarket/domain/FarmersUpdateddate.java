package com.rubix.farmersmarket.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

@Embeddable
public class FarmersUpdateddate {
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@Column(nullable=true)
	private Date updatedDate;
	@Column(columnDefinition="integer default 0")
	private long updatedDateEpoch;

	public FarmersUpdateddate() {

	}

	public FarmersUpdateddate(Date updatedDate, long updatedDateEpoch) {
		super();
		this.updatedDate = updatedDate;
		this.updatedDateEpoch = updatedDateEpoch;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getUpdatedDateEpoch() {
		return updatedDateEpoch;
	}

	public void setUpdatedDateEpoch(long updatedDateEpoch) {
		this.updatedDateEpoch = updatedDateEpoch;
	}

}
