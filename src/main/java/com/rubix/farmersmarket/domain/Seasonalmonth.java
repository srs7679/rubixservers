package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class Seasonalmonth {
	@ElementCollection
	private List<String> months;

	public Seasonalmonth() {

	}

	public Seasonalmonth(List<String> months) {
		super();
		this.months = months;
	}

	public List<String> getMonths() {
		return months;
	}

	public void setMonths(List<String> months) {
		this.months = months;
	}

}
