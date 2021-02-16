package com.springbootproject.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.springbootproject.test.entities.Book_3;

public interface BookRepository_3 extends CrudRepository<Book_3, Integer> {

	public Book_3 findById(int id) ;
	
}
