package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class Packagingneeds {
	public boolean freezer;
	public int max_n_daysOutside;
	public boolean openPacking;
	public boolean closedPacking;

	public Packagingneeds() {

	}

	public Packagingneeds(boolean freezer, int max_n_daysOutside, boolean openPacking, boolean closedPacking) {
		super();
		this.freezer = freezer;
		this.max_n_daysOutside = max_n_daysOutside;
		this.openPacking = openPacking;
		this.closedPacking = closedPacking;
	}

	public boolean isFreezer() {
		return freezer;
	}

	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}

	public int getMax_n_daysOutside() {
		return max_n_daysOutside;
	}

	public void setMax_n_daysOutside(int max_n_daysOutside) {
		this.max_n_daysOutside = max_n_daysOutside;
	}

	public boolean isOpenPacking() {
		return openPacking;
	}

	public void setOpenPacking(boolean openPacking) {
		this.openPacking = openPacking;
	}

	public boolean isClosedPacking() {
		return closedPacking;
	}

	public void setClosedPacking(boolean closedPacking) {
		this.closedPacking = closedPacking;
	}

}
