package com.rubix.farmersmarket.domain;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "feedback", schema = "public")
public class FarmersFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long feedbackId;
	private String name;
	private String comments;
	private float satisfymeter;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmerId")
	private Farmers farmers;

	public FarmersFeedback() {

	}

	public FarmersFeedback(long feedbackId, String name, String comments, float satisfymeter) {
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

	public Farmers getFarmers() {
		return farmers;
	}

	public void setFarmers(Farmers farmers) {
		this.farmers = farmers;
	}

	

}
