package com.vvishnoi.classified.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vvishnoi.classified.model.Item;
import com.vvishnoi.classified.repository.ItemRepository;
import com.vvishnoi.classified.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository repo;

	@Autowired
	private ItemService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> list() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Item save(@RequestBody Item value) {
		return service.save(value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Item get(@PathVariable("id") int id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item update(@PathVariable("id") int id, @RequestBody Item value) {
		return repo.save(value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		repo.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
}
