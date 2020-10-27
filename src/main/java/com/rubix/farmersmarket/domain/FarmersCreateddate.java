package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

@Embeddable
public class FarmersCreateddate {
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@Column(nullable=true)
	private Date createdDate;
	@Column(columnDefinition="integer default 0")
	private long createdDateEpoch;

	public FarmersCreateddate() {

	}

	public FarmersCreateddate(Date createdDate, long createdDateEpoch) {
		super();
		this.createdDate = createdDate;
		this.createdDateEpoch = createdDateEpoch;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getCreatedDateEpoch() {
		return createdDateEpoch;
	}

	public void setCreatedDateEpoch(long createdDateEpoch) {
		this.createdDateEpoch = createdDateEpoch;
	}

}
