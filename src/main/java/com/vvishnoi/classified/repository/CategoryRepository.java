package com.vvishnoi.classified.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vvishnoi.classified.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
	@Override
	List<Category> findAll();

}
