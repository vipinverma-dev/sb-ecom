package com.ecommerce.project.dto;

import java.time.LocalDate;
import java.util.List;

public class CreateOrderRequest {
	
	private Long userId;
    private LocalDate orderdate;  
    private List<OrderItemRequest> orderitems;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	public List<OrderItemRequest> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<OrderItemRequest> orderitems) {
		this.orderitems = orderitems;
	}
    

}
