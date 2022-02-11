package com.mouritech.onlineshoppingsystem.entity;



import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id",length = 64)
	private String prodId;

	@Column(name = "Name", length = 255, nullable = false)
	private String prodName;

	@Column(name = "Price", nullable = false)
	private double price;

	@Lob
	@Column(name = "Image")
	private String image;

	@Column(name = "Description ", nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Category_id", referencedColumnName = "Category_id")
	private Category category;

	@ManyToOne()
	private AddToCart cart;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String prodId, String name, double price, String image, String description) {
		super();
		this.prodId = prodId;
		this.prodName = name;
		this.price = price;
		this.image = image;
		this.description = description;
		
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", image=" + image
				+ ", description=" + description + ", category=" + category + ", cart=" + cart + "]";
	}

	public Product(String prodId, String prodName, double price, String image, String description, Category category,
			AddToCart cart) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.image = image;
		this.description = description;
		this.category = category;
		this.cart = cart;
	}

	public Product(String prodName, double price, String image, String description) {
		super();
		this.prodName = prodName;
		this.price = price;
		this.image = image;
		this.description = description;
		

	}

	
}
