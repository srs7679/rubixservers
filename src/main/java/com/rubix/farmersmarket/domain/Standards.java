package com.rubix.farmersmarket.domain;

import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class Standards {
	public boolean organic;
	public boolean nonGmo;
	public boolean notValidated;

	public Standards() {

	}

	public Standards(boolean organic, boolean nonGmo, boolean notValidated) {
		super();
		this.organic = organic;
		this.nonGmo = nonGmo;
		this.notValidated = notValidated;
	}

	public boolean isOrganic() {
		return organic;
	}

	public void setOrganic(boolean organic) {
		this.organic = organic;
	}

	public boolean isNonGmo() {
		return nonGmo;
	}

	public void setNonGmo(boolean nonGmo) {
		this.nonGmo = nonGmo;
	}

	public boolean isNotValidated() {
		return notValidated;
	}

	public void setNotValidated(boolean notValidated) {
		this.notValidated = notValidated;
	}

}
