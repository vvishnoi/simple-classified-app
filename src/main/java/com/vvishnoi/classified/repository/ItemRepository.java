package com.vvishnoi.classified.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vvishnoi.classified.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	@Override
	List<Item> findAll();

}
