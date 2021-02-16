package com.springbootproject.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbootproject.test.dao.BookRepository;
import com.springbootproject.test.dao.BookRepository_3;
import com.springbootproject.test.entities.Book_3;

@Component
public class BookServices_3 {

	@Autowired
	private BookRepository_3 bookRepository_3;

	// get all Book_3s
	public List<Book_3> getAllBooks() {
		List<Book_3> list = (List<Book_3>) this.bookRepository_3.findAll();
		return list;
	}

	// get single Book_3 by id
	public Book_3 getBookByID(int id) {

		Book_3 book = null;
		try {
			book = this.bookRepository_3.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}

	// Adding the Book_3
	public Book_3 addBook(Book_3 b) {
		Book_3 result = bookRepository_3.save(b);
		return result;
	}

	// Delete Book_3
	public void deleteBook(int bId) {

		this.bookRepository_3.deleteById(bId);

	}

	// Update Book_2
	public void updateBook(Book_3 book, int bId) {

		book.setId(bId);
		this.bookRepository_3.save(book);

	}
}
