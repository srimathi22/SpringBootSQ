package com.srimathi.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srimathi.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("select name from User where contact = '1234'")
	String findUserByContact(String contact);
	

}
