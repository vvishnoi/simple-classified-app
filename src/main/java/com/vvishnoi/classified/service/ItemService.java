package com.vvishnoi.classified.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvishnoi.classified.model.Item;
import com.vvishnoi.classified.model.Location;
import com.vvishnoi.classified.model.Owner;
import com.vvishnoi.classified.repository.ItemRepository;
import com.vvishnoi.classified.repository.LocationRepository;
import com.vvishnoi.classified.repository.OwnerRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private OwnerRepository ownerRepo;

	@Autowired
	private LocationRepository locationRepo;

	public Item save(Item item) {
		
		Owner owner = ownerRepo.save(item.getOwner());
		item.setOwner(owner);
		
		Location location  =  locationRepo.save(item.getLocation());
		item.setLocation(location);
		
		return itemRepo.save(item);
	}

}
