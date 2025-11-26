package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.model.Product;

public interface ProductService {
	void createProduct(Product product);
	List<Product> getallProducts();
	Product getProductById(Long id);
	Product updateProduct(Product product,Long productId);
	String deleteProduct(Long id);
	

}
