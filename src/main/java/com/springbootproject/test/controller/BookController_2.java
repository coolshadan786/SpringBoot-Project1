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

import com.springbootproject.test.entities.Book_2;
import com.springbootproject.test.services.BookServices_2;

@RestController
public class BookController_2 {

	@Autowired
	private BookServices_2 bookServices_2;
	
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	//@ResponseBody								//Use if we have a String type value in controller
	@GetMapping("/bA")						//Use as same as like but it has @RequestMapping by default get method Https type for sending data
	public String getBooks() {
		return "This is testing book.first";
	}
	
	
	@GetMapping("/bok") // Use as same as like but it has @RequestMapping by
	public Book_2 getBook() {

		Book_2 book = new Book_2();
		book.setId(12345);
		book.setTitle("Java Complete Refernces");
		book.setAuthor("XYZ");
		return book;
	}
	
	/*
	 * //get All books handler							//Using Simple return Book obj without try/catch and ResponseEntity<T>
	 * 
	 * @GetMapping("/books1") // Use as same as like but it has @RequestMapping by
	 * public List<Book_2> getBooks1() {
	 * 
	 * return this.bookServices_2.getAllBooks(); }
	 */
	
	
	
	//get All books handler								//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
		@GetMapping("/booksA") // Use as same as like but it has @RequestMapping by
		public ResponseEntity<List<Book_2>> getBooks1() {

			List<Book_2> list=this.bookServices_2.getAllBooks();
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	
		/*
		 * //get single books handler					//Using Simple return Book obj without try/catch and ResponseEntity<T>
		 * 
		 * @GetMapping("/book/{id}") public Book getSingleBook(@PathVariable("id") int
		 * id) { return bookServices_2.getBookByID(id); }
		 */
		
		
		// get single books handler
		@GetMapping("/bookC/{id}")						//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
		public ResponseEntity<Book_2> getSingleBook(@PathVariable("id") int id) {
			Book_2 book = bookServices_2.getBookByID(id);
			if(book==null) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
			}
			return ResponseEntity.of(Optional.of(book));
		}
	 
	//Add new book handler
	@PostMapping("/booksD")								//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Book_2> addBook(@RequestBody Book_2 book) {
		
		Book_2 b = null ;
		
		try {
			b = this.bookServices_2.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}
	
	//Delete new book handler
	@DeleteMapping("/bookE/{bookId}")					//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		
		try {
			this.bookServices_2.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	  
	/*		/Update book handler //Using Simple return
	 * Book obj without try/catch and ResponseEntity<T> 
	 * @PutMapping("/bookF/{bookId}") /public Book_2
	 * updateBook(@PathVariable("bookId") int bookId, @RequestBody Book_2 book) {
	 * this.bookServices_2.updateBook(book, bookId); return book; }
	 */
	 
	
	
	//Update book handler
	@PutMapping("/bookG/{bookId}")							//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Book_2> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book_2 book) {
		
		try {
			this.bookServices_2.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}