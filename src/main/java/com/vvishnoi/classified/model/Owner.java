package com.vvishnoi.classified.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "owner")
public class Owner extends NamedEntity {

	@JsonManagedReference(value = "item-owner")
	@OneToMany(mappedBy = "owner")
	private Set<Item> item;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

}
