package com.rubix.farmersmarket.domain;
import javax.persistence.Embeddable;

import java.util.List;

import javax.persistence.ElementCollection;

@Embeddable
public class Description {
	@ElementCollection
	private List<String> description;
	public Description() {
		
	}
	
	public Description(List<String> description) {
		super();
		this.description = description;
	}

	public List<String> getDescription() {
		return description;
	}
	public void setDescription(List<String> description) {
		this.description = description;
	}

}
