package com.rubix.farmersmarket.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author kausar
 * @class product This class used for product entity
 *
 */
@Entity
@Embeddable
@Table(name = "product", schema = "public")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long productId;
	private String fullName;
	//@Embedded
	private String description;
	//@Embedded
	//private ProductAssignedzone assignedzone;
	private boolean isSeasonal;
	//@Embedded
	private String seasonalmonth;
	//@Embedded
	private String quantitymetrics;
	private int maxperorder;
	//@Embedded
	private String packagingneeds;
	private boolean packagereveal;
	//@Embedded
	private String standards;
	private boolean isActive;
	private boolean isPriorityProduct = false;
	private int orderedQuantity;
	private int deliveredQuantity;
	//@Embedded
	private int rating;
	//@Embedded
	//private ProductCreateddate createddate;
	//@Embedded
	//private ProductUpdateddate updateddate;

	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<ProductFeedback> feedbacks;

	public Product() {

	}

	public Product(long productId, String fullName, String description,
			boolean isSeasonal, String seasonalmonth, String quantitymetrics, int maxperorder,
			String packagingneeds, boolean packagereveal, String standards, boolean isActive,
			boolean isPriorityProduct, int orderedQuantity, int deliveredQuantity, int rating,
			 List<ProductFeedback> feedbacks) {
		super();
		this.productId = productId;
		this.fullName = fullName;
		this.description = description;
		//this.assignedzone = assignedzone;
		this.isSeasonal = isSeasonal;
		this.seasonalmonth = seasonalmonth;
		this.quantitymetrics = quantitymetrics;
		this.maxperorder = maxperorder;
		this.packagingneeds = packagingneeds;
		this.packagereveal = packagereveal;
		this.standards = standards;
		this.isActive = isActive;
		this.isPriorityProduct = isPriorityProduct;
		this.orderedQuantity = orderedQuantity;
		this.deliveredQuantity = deliveredQuantity;
		this.rating = rating;
		//this.createddate = createddate;
		//this.updateddate = updateddate;
		this.feedbacks = feedbacks;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public ProductAssignedzone getAssignedzone() {
//		return assignedzone;
//	}
//
//	public void setAssignedzone(ProductAssignedzone assignedzone) {
//		this.assignedzone = assignedzone;
//	}

	public boolean isSeasonal() {
		return isSeasonal;
	}

	public void setSeasonal(boolean isSeasonal) {
		this.isSeasonal = isSeasonal;
	}

	public String getSeasonalmonth() {
		return seasonalmonth;
	}

	public void setSeasonalmonth(String seasonalmonth) {
		this.seasonalmonth = seasonalmonth;
	}

	public String getQuantitymetrics() {
		return quantitymetrics;
	}

	public void setQuantitymetrics(String quantitymetrics) {
		this.quantitymetrics = quantitymetrics;
	}

	public int getMaxperorder() {
		return maxperorder;
	}

	public void setMaxperorder(int maxperorder) {
		this.maxperorder = maxperorder;
	}

	public String getPackagingneeds() {
		return packagingneeds;
	}

	public void setPackagingneeds(String packagingneeds) {
		this.packagingneeds = packagingneeds;
	}

	public boolean isPackagereveal() {
		return packagereveal;
	}

	public void setPackagereveal(boolean packagereveal) {
		this.packagereveal = packagereveal;
	}

	public String getStandards() {
		return standards;
	}

	public void setStandards(String standards) {
		this.standards = standards;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isPriorityProduct() {
		return isPriorityProduct;
	}

	public void setPriorityProduct(boolean isPriorityProduct) {
		this.isPriorityProduct = isPriorityProduct;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public int getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(int deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

//	public ProductCreateddate getCreateddate() {
//		return createddate;
//	}
//
//	public void setCreateddate(ProductCreateddate createddate) {
//		this.createddate = createddate;
//	}
//
//	public ProductUpdateddate getUpdateddate() {
//		return updateddate;
//	}
//
//	public void setUpdateddate(ProductUpdateddate updateddate) {
//		this.updateddate = updateddate;
//	}

	public List<ProductFeedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<ProductFeedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	

}
