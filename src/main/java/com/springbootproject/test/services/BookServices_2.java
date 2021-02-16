package com.springbootproject.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbootproject.test.dao.BookRepository;
import com.springbootproject.test.entities.Book_2;

@Component 							// Here we can also use service
public class BookServices_2 {

	@Autowired
	private BookRepository bookRepository;

	//get all Book_2s
	public List<Book_2> getAllBooks() {
		List<Book_2> list = (List<Book_2>) this.bookRepository.findAll();
		return list;
	}

	// get single Book_2 by id
	public Book_2 getBookByID(int id) {

		Book_2 book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}

	// Adding the Book_2
	public Book_2 addBook(Book_2 b) {
		Book_2 result = bookRepository.save(b);
		return result;
	}

	// Delete Book_2
	public void deleteBook(int bId) {

		this.bookRepository.deleteById(bId);

	}

	// Update Book_2
	public void updateBook(Book_2 book, int bId) {

		book.setId(bId);
		this.bookRepository.save(book);

	}

}
