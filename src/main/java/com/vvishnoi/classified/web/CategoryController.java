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

import com.vvishnoi.classified.model.Category;
import com.vvishnoi.classified.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> list() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Category save(@RequestBody Category value) {
		return repo.save(value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category get(@PathVariable("id") int id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Category update(@PathVariable("id") int id, @RequestBody Category value) {
		return repo.save(value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		repo.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}

}
