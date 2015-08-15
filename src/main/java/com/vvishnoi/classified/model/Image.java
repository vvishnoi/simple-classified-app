package com.vvishnoi.classified.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "images")
public class Image extends BaseEntity {

	public Image() {
	}
	
	@JsonBackReference(value="item-image")
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "url")
	private String url;

	@Column(name = "main_image")
	private boolean mainImage;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isMainImage() {
		return mainImage;
	}

	public void setMainImage(boolean mainImage) {
		this.mainImage = mainImage;
	}

}
