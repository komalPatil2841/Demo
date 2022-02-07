package com.mouritech.onlineshoppingsystem.model;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "product_id")
	 private long prodId;

	    @Column(name = "Name", length = 255, nullable = false)
	    private String prodName;

	    @Column(name = "Price", nullable = false)
	    private double price;

	    @Lob
	    @Column(name = "Image")
	    private byte[] image;
	    
	    @Column(name = "Description ", nullable = false)
	    private String description ;
	    
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="Category_id", referencedColumnName="Category_id")
	 private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long prodId, String name, double price, byte[] image, String description, Category category) {
		super();
		this.prodId = prodId;
		this.prodName = name;
		this.price = price;
		this.image = image;
		this.description = description;
		this.category = category;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String name) {
		this.prodName = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", name=" + prodName + ", price=" + price + ", image=" + Arrays.toString(image)
				+ ", description=" + description + ", category=" + category + "]";
	}

	 
	 
}
