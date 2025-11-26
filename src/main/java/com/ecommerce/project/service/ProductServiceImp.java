package com.ecommerce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.repositories.ProductRepository;


@Service
public class ProductServiceImp implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	 public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository) {
	        this.productRepository = productRepository;
	        this.categoryRepository = categoryRepository;
	    }

	
	@Override
	public void createProduct(Product product) {
		System.out.println("CategoryId received = " + product.getCategory().getCategoryid());
		Long categoryId = product.getCategory().getCategoryid();

        // ✅ Step 1: Fetch existing Category from DB
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

        // ✅ Step 2: Attach that *managed* category to the product
        product.setCategory(existingCategory);

        // ✅ Step 3: Save product
        productRepository.save(product);
    }
		
	

	@Override
	public List<Product> getallProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		
		return null;
	}

	@Override
	public Product updateProduct(Product product,Long productId) {
		 Product savedProduct = productRepository.findById(productId)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"resouce not found"));
			product.setProductId(productId);
			savedProduct = productRepository.save(product);
			return savedProduct;
	}

	@Override
	public String deleteProduct(Long productId) {
		Product getproduct = productRepository.findById(productId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "resouce not found"));
		
		productRepository.delete(getproduct);
		return "Category with CategoryID: "+productId +" is deleted.";
		
	}

}
