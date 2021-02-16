package com.springbootproject.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.springbootproject.test.entities.Book_2;

public interface BookRepository extends CrudRepository<Book_2, Integer> {

	public Book_2 findById(int id) ;
	
}
