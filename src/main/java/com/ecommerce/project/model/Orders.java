package com.ecommerce.project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	private LocalDate orderdate;
	private double totalamount;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User users;

	public Orders(Long orderId, LocalDate orderdate, double totalamount, User users) {
		super();
		this.orderId = orderId;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.users = users;
	}

	
	
	
	public Orders() {
		super();
	}




	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	
	
	
	
	
}
