package com.rubix.farmersmarket.domain;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class Preferredlanguage {
	@ElementCollection
	private List<String> languages;
	public  Preferredlanguage() {
		
	}
	
	public Preferredlanguage(List<String> languages) {
		super();
		this.languages = languages;
	}

	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	
}
