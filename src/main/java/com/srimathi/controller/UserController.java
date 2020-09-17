package com.srimathi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srimathi.model.User;
import com.srimathi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();	
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);	
	}
	@GetMapping("/contactuser")
	public String getUseronContact() {
		return userService.getUseronContact();
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateuser(id,user), HttpStatus.CREATED);
		
	}
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
		
	}

}
