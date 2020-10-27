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
@Table(name = "feedbacks", schema = "public")
public class ProductFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long feedbackId;
	private String name;
	private String comments;
	private float satisfymeter;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;

	public ProductFeedback() {

	}

	public ProductFeedback(long feedbackId, String name, String comments, float satisfymeter) {
		super();
		this.feedbackId = feedbackId;
		this.name = name;
		this.comments = comments;
		this.satisfymeter = satisfymeter;
	}

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public float getSatisfymeter() {
		return satisfymeter;
	}

	public void setSatisfymeter(float satisfymeter) {
		this.satisfymeter = satisfymeter;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
