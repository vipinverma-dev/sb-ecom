package com.ecommerce.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.dto.CreateOrderRequest;
import com.ecommerce.project.dto.OrderItemRequest;
import com.ecommerce.project.model.OrderItem;
import com.ecommerce.project.model.Orders;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.model.User;
import com.ecommerce.project.repositories.OrderItemRepository;
import com.ecommerce.project.repositories.OrderRepository;
import com.ecommerce.project.repositories.ProductRepository;
import com.ecommerce.project.repositories.UserRepository;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Orders createOrder(CreateOrderRequest request) {
	    User user = userRepository.findById(request.getUserId())
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

	    Orders order = new Orders();
	    order.setUsers(user);
	    order.setOrderdate(request.getOrderdate());

	    double total = 0;
	    List<OrderItem> orderItems = new ArrayList<>();

	    for (OrderItemRequest itemRequest : request.getOrderitems()) {
	        Product product = productRepository.findById(itemRequest.getProductId())
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

	        OrderItem orderItem = new OrderItem();
	        orderItem.setOrder(order); // link back to order
	        orderItem.setProduct(product);
	        orderItem.setQuantity(itemRequest.getQuantity());
	        orderItem.setPrice((product.getPrice() * itemRequest.getQuantity()));
	       
	        total += orderItem.getPrice();
	        
	        orderItems.add(orderItem);
	       
	    }

	    order.setTotalamount(total);
	    order.setOrderitems(orderItems);

	    return orderRepository.save(order);
	}

//	public Orders createOrder(Long userId, List<OrderItem> items) {
//		User user = userRepository.findById(userId)
//				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found"));
//		Orders order = new Orders();
//		order.setUsers(user);
//		order.setOrderdate(LocalDate.now());
//		
//		double total = 0;
//		for(OrderItem item: items) {
//			Product product = productRepository.findById(item.getProduct().getProductId())
//					.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
//			item.setOrder(order);
//			item.setPrice(product.getPrice()*item.getQuantity());
//			total +=item.getPrice();
//		}
//		order.setTotalamount(total);
//		order.setOrderitems(items);
//		
//		return orderRepository.save(order);
	
	
	

	@Override
	public Orders updateOrder(Orders order, Long orderId) {
		//find existing order
		Orders existingorder = orderRepository.findById(orderId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found."));
		
		//updating user
		Long userId = order.getUsers().getUserId();
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		existingorder.setUsers(user);
		
		// // 3. Update order date
		existingorder.setOrderdate(order.getOrderdate());
		
		//4. Update items
		List<OrderItem> items = order.getOrderitems();
		
		double total = 0;
		
		
//		updatingdorder.setOrderId(orderId);
//		updatingdorder.setUsers(order.getUsers());
//		updatingdorder.setOrderdate(LocalDate.now());
			
			
			
			for(OrderItem item: items) {
				//fetch product
				System.out.println("Incoming itemId: " + item.getOrderItemId());
				Product product = productRepository.findById(item.getProduct().getProductId())
						.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
				// // update item fields
				item.setOrderItemId(item.getOrderItemId());
				item.setProduct(product);
				item.setQuantity(item.getQuantity());
				item.setOrder(existingorder);
				item.setPrice(product.getPrice()*item.getQuantity());
				total +=item.getPrice();
			}
			//Assign update item
			existingorder.setOrderitems(items);
			
			//assign updated total
			existingorder.setTotalamount(total);
			
		    return orderRepository.save(existingorder);
	}

	@Override
	public String deleteOrder(Long orderId) {
		Orders fetchorder = orderRepository.findById(orderId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with this Id: "+orderId));
		orderRepository.delete(fetchorder);
		return "Order deleted with order ID: "+orderId;
	}

	@Override
	public Orders getorderById(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getordersByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getallOrder() {
		
		return orderRepository.findAll();
	}

	@Override
	public List<Product> getProductByOrderId(Long orderId) {
		Orders order = orderRepository.findById(orderId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with this Order Id: "+orderId));
		
	List<Product> products = new ArrayList<Product>();	
	for(OrderItem item : order.getOrderitems()) {
		products.add(item.getProduct());
	}
		return products;
	}

}
