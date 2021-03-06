package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class ProductAssignedzone {
	@ElementCollection
	private List<String> zones;

	public ProductAssignedzone() {

	}

	public ProductAssignedzone(List<String> zones) {
		super();
		this.zones = zones;
	}

	public List<String> getZones() {
		return zones;
	}

	public void setZones(List<String> zones) {
		this.zones = zones;
	}

}
