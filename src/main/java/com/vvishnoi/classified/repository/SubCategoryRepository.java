package com.vvishnoi.classified.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vvishnoi.classified.model.SubCategory;

public interface SubCategoryRepository
		extends CrudRepository<SubCategory, Integer> {

	@Override
	List<SubCategory> findAll();

}
