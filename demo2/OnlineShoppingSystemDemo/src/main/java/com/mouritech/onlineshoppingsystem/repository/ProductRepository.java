package com.mouritech.onlineshoppingsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mouritech.onlineshoppingsystem.entity.Product;

@Repository
public  interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByProdId(String prodId);
	List<Product> findByProdName(String prodId);
}


