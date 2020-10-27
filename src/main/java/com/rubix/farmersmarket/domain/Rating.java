package com.rubix.farmersmarket.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class Rating {
	@ElementCollection
	private List<String> stars;

	public Rating() {

	}

	public Rating(List<String> stars) {
		super();
		this.stars = stars;
	}

	public List<String> getStars() {
		return stars;
	}

	public void setStars(List<String> stars) {
		this.stars = stars;
	}

}
