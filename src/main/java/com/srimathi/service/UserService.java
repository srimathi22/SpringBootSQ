package com.srimathi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srimathi.dao.UserRepository;
import com.srimathi.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	public User getUserById(int id) {
		
		return userRepository.findById(id).get();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateuser(int id, User u) {
		User user = userRepository.findById(id).get();
		if(user==null)
			throw new RuntimeException(new IllegalArgumentException());
		if(u.getName()!=null)
			user.setName(u.getName());
		return user;
		
	}

	public String deleteUser(int id) {
		 userRepository.deleteById(id);
		return "deleted";
	}

	public String getUseronContact() {
		String contact = null;
		return userRepository.findUserByContact(contact);
	}

}
