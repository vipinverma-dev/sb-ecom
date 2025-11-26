package com.ecommerce.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long orderItemId;
	private int quantity;
	private double price;
	
	
	@ManyToOne
	@JoinColumn(name="order_id")
	 @JsonIgnore   // don't serialize the parent order
	private Orders order;
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@JsonIgnore   // don't serialize product here
	private Product product;
	

	
//	public OrderItem(long orderItemId, int quantity, double price, Orders order, Product product) {
//		super();
//		this.orderItemId = orderItemId;
//		this.quantity = quantity;
//		this.price = price;
//		this.order = order;
//		this.product = product;
//	}
	
	

	public OrderItem() {
		super();
	}

	public OrderItem(long orderItemId, int quantity, double price, Orders order, Product product) {
	super();
	this.orderItemId = orderItemId;
	this.quantity = quantity;
	this.price = price;
	this.order = order;
	this.product = product;
}

	public long getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
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


	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getOrderitems() {
		// TODO Auto-generated method stub
		return null;
	}

}
