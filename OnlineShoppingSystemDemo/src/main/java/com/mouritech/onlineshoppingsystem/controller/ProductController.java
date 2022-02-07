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

import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;
import com.mouritech.onlineshoppingsystem.model.Product;
import com.mouritech.onlineshoppingsystem.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	//get all products
	@GetMapping("/productslist")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
		
	}
	
	//create product
	@PostMapping("/addproduct")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	// get product by id
	@GetMapping("/productslist/{id}")
	public ResponseEntity<Product>  getProductById(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product not exits with id :" + id));
	return ResponseEntity.ok(product);
	
	}
	
	// update product
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id , @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product not exits with id :" + id));
		
		product.setProdName(productDetails.getProdName());
		product.setPrice(productDetails.getPrice());
		product.setDescription(productDetails.getDescription());
		product.setImage(productDetails.getImage());
		product.setCategory(productDetails.getCategory());
		
		Product updatedProduct = productRepository.save(product);
		
		return ResponseEntity.ok(updatedProduct);
		
	}
	
	// delete product
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product not exits with id :" + id));
		productRepository.delete(product);
		
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
