package com.vvishnoi.classified.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categories")

public class Category extends NamedEntity {

	public Category() {
	}
	
	@JsonManagedReference(value="category-subcategory")
	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL,  fetch = FetchType.EAGER)
	private Set<SubCategory> subCategories;

	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

}
