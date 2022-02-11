package com.mouritech.onlineshoppingsystem.service;

import java.util.List;

import com.mouritech.onlineshoppingsystem.entity.Product;
import com.mouritech.onlineshoppingsystem.exception.ProductNotFoundException;



public interface ProductService {

	Product insertProduct(Product newProduct);

	Product showProductById(String prodId) throws ProductNotFoundException;

	List<Product> showAllProducts();



	Product updateProductById(String prodId, Product product) throws ProductNotFoundException;

	void deleteProductById(String prodId) throws ProductNotFoundException;

}
