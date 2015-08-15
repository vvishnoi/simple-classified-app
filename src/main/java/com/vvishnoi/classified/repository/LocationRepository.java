package com.vvishnoi.classified.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vvishnoi.classified.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {
	@Override
	List<Location> findAll();

}
