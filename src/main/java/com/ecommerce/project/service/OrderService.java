package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.dto.CreateOrderRequest;
import com.ecommerce.project.dto.OrderItemRequest;
import com.ecommerce.project.model.OrderItem;
import com.ecommerce.project.model.Orders;
import com.ecommerce.project.model.Product;

public interface OrderService {
	Orders createOrder(CreateOrderRequest request);
	Orders updateOrder(Orders order,Long orderId);
	String deleteOrder(Long orderId);
	Orders getorderById(Long orderId);
	List<Orders> getordersByUserId(Long userId);
	List<Orders> getallOrder();
	List<Product> getProductByOrderId(Long ordreId);

}
