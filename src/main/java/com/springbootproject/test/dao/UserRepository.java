package com.springbootproject.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springbootproject.test.entities.User;


public interface UserRepository extends CrudRepository<User, Integer> {

	//Custom finder method / Derived Mtdh on a prototype function
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name,String city);
	
	//Annotation Query 
	@Query("select u FROM User u")
	public List<User> getAllUser();
	
	@Query("select u FROM User u WHERE u.name=:n")
	public List<User> getAllUserByName(@Param("n") String name);
	
	@Query("select u FROM User u WHERE u.name=:n and u.city=:c")
	public List<User> getAllUserByNameAndCity(@Param("n") String name,@Param("c") String city);
	
	@Query(value = "select * from user",nativeQuery = true)
	public List<User> getUsers();
}
