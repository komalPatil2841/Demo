package com.mouritech.onlineshoppingsystem.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;
import com.mouritech.onlineshoppingsystem.entity.Product;

import com.mouritech.onlineshoppingsystem.service.ProductService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("product")
	public Product insertProduct(@RequestBody Product newProduct) {
		
		return productService.insertProduct(newProduct);
		
	}
	
	@GetMapping("product")
	public List<Product> showAllProducts(){
		return productService.showAllProducts();
		
	}
	
	@GetMapping("product/{pid}")
	public Product showProductById(@PathVariable("pid") String prodId) throws ProductNotFoundException{
		return productService.showProductById(prodId);
		
	}
	
	@PutMapping("product/{pid}")
	public Product updateProductById(@PathVariable("pid") String prodId,@RequestBody Product product) throws ProductNotFoundException{
		return productService.updateProductById(prodId,product);
		
	}
	
	@DeleteMapping("product/{pid}")
	public String deleteProductById(@PathVariable("pid") String prodId) throws ProductNotFoundException{
		 productService.deleteProductById(prodId);
		 return "deleted the product";
		
	}
}
