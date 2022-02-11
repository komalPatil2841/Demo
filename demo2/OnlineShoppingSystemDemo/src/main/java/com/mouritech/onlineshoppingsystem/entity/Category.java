package com.mouritech.onlineshoppingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Category_id",length = 64)
	private String catId;

	@Column(name = "Category_name")
	private String catName;

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + "]";
	}

}
