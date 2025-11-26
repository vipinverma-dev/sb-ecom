package com.ecommerce.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Orders;
import com.ecommerce.project.model.User;

public interface OrderRepository extends JpaRepository<Orders, Long>{
//	List<Orders> findByUser(User user);

}
