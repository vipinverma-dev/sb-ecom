package com.ecommerce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.User;
import com.ecommerce.project.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User getUserById(Long id) {
		
		return null;
	}

	@Override
	public User updateUser(User user,Long userId) {
		User saveduser= userRepository.findById(userId)
				.orElseThrow (() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"resource not found"));
		user.setUserId(userId);
		return  userRepository.save(user);
		
	}

	@Override
	public String deleteUser(Long id) {
		User savedUser1 = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"resource not found"));
		userRepository.delete(savedUser1);
		return "User with UserId: "+id+" is deleted";
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}


}
