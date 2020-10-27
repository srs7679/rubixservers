package com.rubix.farmersmarket.domain;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "deliveryqueries", schema = "public")
public class FarmersDeliveryqueries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long queryId;
	private String querytitle;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmerId")
	private Farmers farmers;
	
	public FarmersDeliveryqueries() {
		
	}
	public FarmersDeliveryqueries(String querytitle) {
		super();
		this.querytitle = querytitle;
	}

	public String getQuerytitle() {
		return querytitle;
	}

	public void setQuerytitle(String querytitle) {
		this.querytitle = querytitle;
	}
	public long getQueryId() {
		return queryId;
	}
	public void setQueryId(long queryId) {
		this.queryId = queryId;
	}
	public Farmers getFarmers() {
		return farmers;
	}
	public void setFarmers(Farmers farmers) {
		this.farmers = farmers;
	}

}
