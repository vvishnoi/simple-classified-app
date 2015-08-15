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
@Table(name = "items")
public class Item extends NamedEntity {

	public Item() {
	}

	@JsonBackReference(value="item-owner")
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@JsonBackReference(value="item-subcategory")
	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@JsonBackReference(value="item-location")
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@JsonManagedReference(value="item-image")
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Image> images;

	@Column(name = "detail")
	private String detail;



	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
