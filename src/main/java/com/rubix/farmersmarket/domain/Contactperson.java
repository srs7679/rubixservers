package com.rubix.farmersmarket.domain;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.ElementCollection;

@Embeddable
public class Contactperson {
	@ElementCollection
	private List<String> name;

	public Contactperson() {

	}

	public Contactperson(List<String> name) {
		super();
		this.name = name;
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

}
