package com.uangteman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uangteman.entity.Category;
import com.uangteman.repo.CategoryRepo;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryRepo repo;
	
	@RequestMapping(method=RequestMethod.POST)
	public Category insert(@RequestBody Category category) {
		return repo.save(category);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Category findById(@PathVariable("id") Long id) {		
		return repo.findOne(id);
	}
}
