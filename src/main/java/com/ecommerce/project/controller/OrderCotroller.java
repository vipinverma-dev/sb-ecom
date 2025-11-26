package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.dto.CreateOrderRequest;
import com.ecommerce.project.model.OrderItem;
import com.ecommerce.project.model.Orders;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.service.OrderService;

@RestController
public class OrderCotroller {
	private OrderService orderService;
	
	
	public OrderCotroller(OrderService orderService) {
		super();
		this.orderService = orderService;
	}




	@PostMapping("/api/public/orders")
	public ResponseEntity<String> createOrder(@RequestBody  CreateOrderRequest request){
											
//		orderService.createOrder(request.getUserId(),request.getOrderitems());
		orderService.createOrder(request);
		return new ResponseEntity<>("Order Created attached to: "+request.getUserId(),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/api/public/orders/{orderid}")
	public ResponseEntity<String> updateOrder(@RequestBody Orders order,@PathVariable Long orderid){
		try {
			Orders saveorder = orderService.updateOrder(order, orderid);
			return new ResponseEntity<String>("Order updated with OrderId "+orderid,HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
		
	}
	
	@DeleteMapping("/api/admin/orders/{orderId}")
	public ResponseEntity<String> deleteorder(@PathVariable Long orderId){
		try {
			String deletedorders = orderService.deleteOrder(orderId);
			return new ResponseEntity<>(deletedorders,HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
		
	}
						
	@GetMapping("/api/admin/orders")
	public ResponseEntity<List<Orders>> getallorder(){
		List<Orders> order = orderService.getallOrder();
		return new ResponseEntity<>(order,HttpStatus.OK);
		
	}
	
	@GetMapping("/api/admin/orders/{orderId}/products")
	public ResponseEntity<?> getProductsByOrder(@PathVariable Long orderId){
	try {
		List<Product> products = orderService.getProductByOrderId(orderId);
		return new ResponseEntity<>(products,HttpStatus.OK);
	} catch (ResponseStatusException e) {
		return new ResponseEntity<>(e.getReason(),e.getStatusCode());
	}
	
	}
	
	
}
