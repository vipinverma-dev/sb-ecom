
package com.ecommerce.project.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	private LocalDate orderdate;
	
	private double totalamount;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User users;
	
	@OneToMany(mappedBy ="order", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"order", "product"})   // ignore these fields when serializing
	private List<OrderItem> orderitems;




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


	public List<OrderItem> getOrderitems() {
		return orderitems;
	}




	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	
	
	
	
}
