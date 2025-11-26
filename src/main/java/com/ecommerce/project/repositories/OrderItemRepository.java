package com.ecommerce.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.OrderItem;
import com.ecommerce.project.model.Orders;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//	List<OrderItem> findbyOrder(Orders order);

}
