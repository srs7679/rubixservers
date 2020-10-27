package com.rubix.farmersmarket.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class FarmersEpoch {
	@ElementCollection
	private List<String> epoch;

	public FarmersEpoch() {

	}

	public FarmersEpoch(List<String> epoch) {
		super();
		this.epoch = epoch;
	}

	public List<String> getEpoch() {
		return epoch;
	}

	public void setEpoch(List<String> epoch) {
		this.epoch = epoch;
	}

}
