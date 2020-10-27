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
@Table(name = "products", schema = "public")
public class FarmersProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long productId;
	private String productName;
	@JsonFormat(shape = Shape.STRING)
	private long maxsellingcapacity;
	@JsonFormat(shape = Shape.STRING)
	private long listprice;
	@JsonFormat(shape = Shape.STRING)
	private long sellingprice;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmerId")
	private Farmers farmers;
	
	public FarmersProduct() {
		
	}
	public FarmersProduct(long productId, String productName, long maxsellingcapacity, long listprice, long sellingprice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.maxsellingcapacity = maxsellingcapacity;
		this.listprice = listprice;
		this.sellingprice = sellingprice;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getMaxsellingcapacity() {
		return maxsellingcapacity;
	}
	public void setMaxsellingcapacity(long maxsellingcapacity) {
		this.maxsellingcapacity = maxsellingcapacity;
	}
	public long getListprice() {
		return listprice;
	}
	public void setListprice(long listprice) {
		this.listprice = listprice;
	}
	public long getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(long sellingprice) {
		this.sellingprice = sellingprice;
	}
	public Farmers getFarmers() {
		return farmers;
	}
	public void setFarmers(Farmers farmers) {
		this.farmers = farmers;
	}
	
	
	
}
