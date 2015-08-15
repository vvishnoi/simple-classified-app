package com.vvishnoi.classified.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vvishnoi.classified.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	@Override
	List<Owner> findAll();

}
