package com.ecommerce.project.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name = "Category")
public class Category {
	
	
	//this POJO class plain old java object
	//sand this class need to mapped to database as table-category,columns are categoryid and categoryname
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;
	private String categoryName;
	
	@OneToMany(mappedBy="category")
	private List<Product> products;
	
	
	public Category(Long categoryid, String categoryName) {
		this.categoryid = categoryid;
		this.categoryName = categoryName;
	}
	
	
	public Category() {
		
	}


	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
