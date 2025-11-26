package com.ecommerce.project.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity(name="Product")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private double price;
	private String discription;
	private double stock;
	
	
	



	@ManyToOne
	@JoinColumn(name= "category_Id")
	private Category category;
	
	
	@OneToMany(mappedBy="product")
	private List<OrderItem> order_item;


//	public Product(long productId, String productName, double price, Category category) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.price = price;
//		this.category = category;
//	}
	

	public Product(long productId, String productName, double price, String discription, double stock,
			Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.discription = discription;
		this.stock = stock;
		this.category = category;
	}

	
	

	public Product() {
		super();
	}




	



	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}




	public String getDiscription() {
		return discription;
	}




	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
	
	
	

}
