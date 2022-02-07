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

import com.mouritech.onlineshoppingsystem.exception.CustomerNotFoundException;
import com.mouritech.onlineshoppingsystem.model.Customer;
import com.mouritech.onlineshoppingsystem.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get all customers
	@GetMapping("/customerslist")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
		
	}
	
	//create customer
	@PostMapping("/addcustomer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	// get customer by id
	@GetMapping("/customerslist/{id}")
	public ResponseEntity<Customer>  getCustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("customer not exits with id :" + id));
	return ResponseEntity.ok(customer);
	
	}
	
	// update customer
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id , @RequestBody Customer customerDetails){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("customer not exits with id :" + id));
		
		customer.setCustName(customerDetails.getCustName());
		customer.setCustEmail(customerDetails.getCustEmail());
		customer.setCustAddress(customerDetails.getCustAddress());
		customer.setCustPhn(customerDetails.getCustPhn());
		customer.setPassword(customerDetails.getPassword());
		
		Customer updatedCustomer = customerRepository.save(customer);
		
		return ResponseEntity.ok(updatedCustomer);
		
	}
	
	// delete customer
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("customer not exits with id :" + id));
		customerRepository.delete(customer);
		
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
}
