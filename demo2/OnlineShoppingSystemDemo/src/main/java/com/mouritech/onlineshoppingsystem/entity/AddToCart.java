package com.mouritech.onlineshoppingsystem.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name = "cart")
public class AddToCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long cartId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "added_date")
	private LocalDate added_date;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Product> products = new HashSet<>();

	@OneToOne(cascade = CascadeType.PERSIST)
     @JoinColumn(name = "custId")

	// @OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;

	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getAdded_date() {
		return added_date;
	}

	public void setAdded_date(LocalDate added_date) {
		this.added_date = added_date;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddToCart(long cartId, int quantity, double price, LocalDate added_date) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.price = price;
		this.added_date = added_date;
	}

	@Override
	public String toString() {
		return "AddToCart [cartId=" + cartId + ", quantity=" + quantity + ", price=" + price + ", added_date="
				+ added_date + ", products=" + products + ", customer=" + customer + "]";
	}



}
