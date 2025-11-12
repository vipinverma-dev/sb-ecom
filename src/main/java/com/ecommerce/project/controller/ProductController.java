package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.service.ProductService;


@RestController
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		
		this.productService = productService;
	}
	
	@PostMapping("/api/public/products")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		productService.createProduct(product);
		
		return new ResponseEntity<>("Product Created",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/public/products")
	public ResponseEntity<List<Product>> getallProducts(){
		List<Product> product = productService.getallProducts();
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	
}
