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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.User;
import com.ecommerce.project.repositories.UserRepository;
import com.ecommerce.project.service.UserService;

@RestController
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/api/public/users")
	public ResponseEntity<List<User>> getallUser(){
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/api/public/users")
	public ResponseEntity<String> createUser(@RequestBody User user){
		userService.createUser(user);
		return new ResponseEntity<> ("User is created with UserID: " +user.getUserId() ,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/api/public/users/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User user,
											@PathVariable Long userId){
		
		
		try {
			User savedUser = userService.updateUser(user,userId);
			  return new ResponseEntity<String>("User updated with UserId: "+userId,HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
												
		
		
	}
	@DeleteMapping("/api/admin/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		try {
			String deleteuser = userService.deleteUser(userId);
			return new ResponseEntity<String>(deleteuser,HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
		
		
	}
	
	
}
