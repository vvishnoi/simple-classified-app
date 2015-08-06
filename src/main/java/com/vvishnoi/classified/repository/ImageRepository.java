package com.vvishnoi.classified.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vvishnoi.classified.model.Image;

public interface ImageRepository extends CrudRepository<Image, Integer> {
	
	@Override
	List<Image> findAll();

}
