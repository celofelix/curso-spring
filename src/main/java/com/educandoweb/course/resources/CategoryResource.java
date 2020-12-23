package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService cateroryService;
	
	@GetMapping
	public ResponseEntity<List<Category>>findAll() {
		List<Category> allCategory = cateroryService.findAll();
		return ResponseEntity.ok().body(allCategory);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findByid(@PathVariable Long id) {
		Category category = cateroryService.findByid(id);
		return ResponseEntity.ok().body(category);
	}

}
