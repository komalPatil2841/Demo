package com.mouritech.onlineshoppingsystem.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlineshoppingsystem.entity.Product;
import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;
import com.mouritech.onlineshoppingsystem.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product newProduct) {
	
		newProduct.setProdId(generateProductId());
		return productRepository.save(newProduct);
	}
	
	
	public String generateProductId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long pId = (long) rand.nextInt(upperbound);
		return "P00" + pId; 
	
	}


	@Override
	public Product showProductById(String prodId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findByProdId(prodId).orElseThrow(() -> new ProductNotFoundException("product not found with id " + prodId));
	}


	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	@Override
	public Product updateProductById(String prodId,Product product) throws ProductNotFoundException {
		Product existingProduct = productRepository.findByProdId(prodId).orElseThrow(() -> new ProductNotFoundException("product not found with id " + prodId));
		existingProduct.setProdName(product.getProdName());
		existingProduct.setPrice(product.getPrice());
		productRepository.save(existingProduct);
		return existingProduct;
	}


	@Override
	public void deleteProductById(String prodId) throws ProductNotFoundException {
		Product existingProduct = productRepository.findByProdId(prodId).orElseThrow(() -> new ProductNotFoundException("product not found with id " + prodId));
		productRepository.delete(existingProduct);
	}

}
