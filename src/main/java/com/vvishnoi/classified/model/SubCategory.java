package com.vvishnoi.classified.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sub_categories")
public class SubCategory extends NamedEntity {

	public SubCategory() {
	}
	
	@JsonBackReference(value="category-subcategory")
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JsonManagedReference(value="item-subcategory")
	@OneToMany(mappedBy = "subCategory", cascade=CascadeType.ALL,  fetch=FetchType.LAZY)
	private Set<Item> items;

	@Column(name = "adult")
	private boolean adult;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
