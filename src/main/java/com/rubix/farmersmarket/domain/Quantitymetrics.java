package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class Quantitymetrics {
	private double kg;
	private double lt;
	private String bunch;
	private String bag;
	private String sack;

	public Quantitymetrics() {

	}

	public Quantitymetrics(double kg, double lt, String bunch, String bag, String sack) {
		super();
		this.kg = kg;
		this.lt = lt;
		this.bunch = bunch;
		this.bag = bag;
		this.sack = sack;
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

	public double getLt() {
		return lt;
	}

	public void setLt(double lt) {
		this.lt = lt;
	}

	public String getBunch() {
		return bunch;
	}

	public void setBunch(String bunch) {
		this.bunch = bunch;
	}

	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}

	public String getSack() {
		return sack;
	}

	public void setSack(String sack) {
		this.sack = sack;
	}

}
