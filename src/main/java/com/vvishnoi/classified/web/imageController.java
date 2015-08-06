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

import com.vvishnoi.classified.model.Image;
import com.vvishnoi.classified.repository.ImageRepository;

@RestController
@RequestMapping("/image")
public class imageController {

	@Autowired
	private ImageRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Image> list() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Image save(@RequestBody Image value) {
		return repo.save(value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Image get(@PathVariable("id") int id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Image update(@PathVariable("id") int id, @RequestBody Image value) {
		return repo.save(value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		repo.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
}
