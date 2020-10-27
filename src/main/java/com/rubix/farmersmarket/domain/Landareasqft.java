package com.rubix.farmersmarket.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class Landareasqft {
	@ElementCollection
	private List<Double> area;

	public Landareasqft() {

	}
	

	public Landareasqft(List<Double> area) {
		super();
		this.area = area;
	}


	public List<Double> getArea() {
		return area;
	}

	public void setArea(List<Double> area) {
		this.area = area;
	}

	

}
