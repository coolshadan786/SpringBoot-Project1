package com.springbootproject.test.controller;

import java.util.List;
import java.util.Optional;

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

import com.springbootproject.test.entities.Book_3;
import com.springbootproject.test.services.BookServices_3;

@RestController
public class BookController_3 {

	@Autowired
	private BookServices_3 bookServices_3;

	// @RequestMapping(value = "/books", method = RequestMethod.GET)
	// @ResponseBody //Use if we have a String type value in controller
	@GetMapping("/bAA") // Use as same as like but it has @RequestMapping by default get method Https type for sending data					
	public String getBooks() {				
		return "This is testing book.first";
	}


	/*
	 * //get All books handler //Using Simple return Book obj without try/catch and
	 * ResponseEntity<T>
	 * 
	 * @GetMapping("/books1") // Use as same as like but it has @RequestMapping by
	 * public List<Book_3> getBooks1() {
	 * 
	 * return this.bookServices_3.getAllBooks(); }
	 */

	// get All books handler //Using return ResponseEntity<Book> obj with try/catch
	// block data for error handling
	@GetMapping("/booksAA") // Use as same as like but it has @RequestMapping by
	public ResponseEntity<List<Book_3>> getBooks1() {

		List<Book_3> list = this.bookServices_3.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	/*
	 * //get single books handler //Using Simple return Book obj without try/catch
	 * and ResponseEntity<T>
	 * 
	 * @GetMapping("/bookas/{id}") public Book getSingleBook(@PathVariable("id") int
	 * id) { return bookServices_2.getBookByID(id); }
	 */

	// get single books handler
	@GetMapping("/bookCC/{id}") // Using return ResponseEntity<Book> obj with try/catch block data for error handling								
	public ResponseEntity<Book_3> getSingleBook(@PathVariable("id") int id) {
		Book_3 book = bookServices_3.getBookByID(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// Add new book handler
	@PostMapping("/booksDD") // Using return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Book_3> addBook(@RequestBody Book_3 book) {

		Book_3 b = null;

		try {
			b = this.bookServices_3.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// Delete new book handler
	@DeleteMapping("/bookEE/{bookId}") // Using return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {

		try {
			this.bookServices_3.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/*
	 * /Update book handler //Using Simple return Book obj without try/catch and
	 * ResponseEntity<T>
	 * 
	 * @PutMapping("/bookFF/{bookId}") /public Book_2
	 * updateBook(@PathVariable("bookId") int bookId, @RequestBody Book_2 book) {
	 * this.bookServices_3.updateBook(book, bookId); return book; }
	 */

	// Update book handler
	@PutMapping("/bookGG/{bookId}") // Using return ResponseEntity<Book> obj with try/catch block data for error handling								
	public ResponseEntity<Book_3> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book_3 book) {

		try {
			this.bookServices_3.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
