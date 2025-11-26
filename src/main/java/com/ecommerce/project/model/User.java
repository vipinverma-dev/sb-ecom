package com.ecommerce.project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String username;
	private String passoword;
	private String email;
	
	@OneToMany(mappedBy="users")
	@JsonManagedReference
	private List<Orders> orders;

	
	
	public User(long userId, String username, String passoword, String email, List<Orders> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.passoword = passoword;
		this.email = email;
		
		this.orders = orders;
		//
		
	}




	public User() {
		super();
	}




	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String getPassoword() {
		return passoword;
	}




	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}




	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	
	
	
	
	

}
