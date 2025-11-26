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

import com.ecommerce.project.model.Category;
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
	
	@DeleteMapping("/api/admin/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
		
		try {
			String status = productService.deleteProduct(productId);
			return new ResponseEntity<> (status , HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<> (e.getReason(),e.getStatusCode());
		}
		
	}
	
	
	
	@PutMapping("/api/admin/products/{productId}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product,
			@PathVariable Long productId){


    try {
       Product savedProduct = productService.updateProduct(product,productId);
       return new ResponseEntity<>("Category with CategoryId "+productId +" is updated",HttpStatus.OK);
      }
      catch(ResponseStatusException e) {
      return new ResponseEntity<>(e.getReason(),e.getStatusCode());
}

}
	
	
}
