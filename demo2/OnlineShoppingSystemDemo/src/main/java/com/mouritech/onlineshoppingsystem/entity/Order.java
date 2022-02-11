package com.mouritech.onlineshoppingsystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "ordered_on")
	private LocalDate orderedOn;
	
	@Column(name = "ordered_status")
	private String orderStatus;

    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name ="custId")
    private Customer customer;

	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getOrderId() {
		return orderId;
	}



	public void setOrderId(long orderId) {
		this.orderId = orderId;
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



	public LocalDate getOrderedOn() {
		return orderedOn;
	}



	public void setOrderedOn(LocalDate orderedOn) {
		this.orderedOn = orderedOn;
	}



	public String getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Order(long orderId, int quantity, double price, LocalDate orderedOn, String orderStatus) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.orderedOn = orderedOn;
		this.orderStatus = orderStatus;
	}



	public Order(int quantity, double price, LocalDate orderedOn, String orderStatus) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.orderedOn = orderedOn;
		this.orderStatus = orderStatus;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", price=" + price + ", orderedOn=" + orderedOn
				+ ", orderStatus=" + orderStatus + ", customer=" + customer + "]";
	}





	

}
