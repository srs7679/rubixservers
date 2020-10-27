package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class ProductRating {
	@ElementCollection
	private List<String> rating;

	public ProductRating() {

	}

	public ProductRating(List<String> rating) {
		super();
		this.rating = rating;
	}

	public List<String> getRating() {
		return rating;
	}

	public void setRating(List<String> rating) {
		this.rating = rating;
	}

}
