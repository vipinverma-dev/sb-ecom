package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.model.User;

public interface UserService {

	
	void createUser(User user);
	User getUserById(Long id);
	String deleteUser(Long id);
	List<User> getAllUser();
	User updateUser(User user, Long id);
	
	
}
