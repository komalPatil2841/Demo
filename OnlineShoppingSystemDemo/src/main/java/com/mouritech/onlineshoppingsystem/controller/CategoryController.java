package com.mouritech.onlineshoppingsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlineshoppingsystem.exception.CategoryNotFoundException;
import com.mouritech.onlineshoppingsystem.model.Category;

import com.mouritech.onlineshoppingsystem.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//get all categorys
		@GetMapping("/categorylist")
		public List<Category> getAllCategorys(){
			return categoryRepository.findAll();
			
		}
		
		//create category
		@PostMapping("/addcategory")
		public Category createCategory(@RequestBody Category category) {
			return categoryRepository.save(category);
			
		}
		
		// get category by id
		@GetMapping("/categorylist/{id}")
		public ResponseEntity<Category>  getCategoryById(@PathVariable Integer id) {
			Category category = categoryRepository.findById(id)
					.orElseThrow(() -> new CategoryNotFoundException("category not exits with id :" + id));
		return ResponseEntity.ok(category);
		
		}
		
		// update category
		@PutMapping("/updatecategory/{id}")
		public ResponseEntity<Category> updateCategory(@PathVariable Integer id , @RequestBody Category categoryDetails){
			Category category = categoryRepository.findById(id)
					.orElseThrow(() -> new CategoryNotFoundException("category not exits with id :" + id));
			
			category.setCatName(categoryDetails.getCatName());
		
			
			Category updatedCategory = categoryRepository.save(category);
			
			return ResponseEntity.ok(updatedCategory);
			
		}
		
		// delete category
		@DeleteMapping("/deletecategory/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Integer id){
			Category category = categoryRepository.findById(id)
					.orElseThrow(() -> new CategoryNotFoundException("category not exits with id :" + id));
			categoryRepository.delete(category);
			
			Map<String , Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}
