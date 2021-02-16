package com.springbootproject.test.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.test.entities.Book;
import com.springbootproject.test.services.BookServices;

@RestController
public class BookController {
	
	@Autowired
	private BookServices bookServices;
	
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	//@ResponseBody								//Use if we have a String type value in controller
	@GetMapping("/books")						//Use as same as like but it has @RequestMapping by default get method Https type for sending data
	public String getBooks() {
		return "This is testing book.first";
	}
	
	
	@GetMapping("/book") // Use as same as like but it has @RequestMapping by
	public Book getBook() {

		Book book = new Book();
		book.setId(12345);
		book.setTitle("Java Complete Refernces");
		book.setAuthor("XYZ");
		return book;
	}
	
	/*
	 * //get All books handler							//Using Simple return Book obj without try/catch and ResponseEntity<T>
	 * 
	 * @GetMapping("/books1") // Use as same as like but it has @RequestMapping by
	 * public List<Book> getBooks1() {
	 * 
	 * return this.bookServices.getAllBooks(); }
	 */
	
	
	
	//get All books handler								//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
		@GetMapping("/books1") // Use as same as like but it has @RequestMapping by
		public ResponseEntity<List<Book>> getBooks1() {

			List<Book> list=this.bookServices.getAllBooks();
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list));
		}
	
		/*
		 * //get single books handler					//Using Simple return Book obj without try/catch and ResponseEntity<T>
		 * 
		 * @GetMapping("/book/{id}") public Book getSingleBook(@PathVariable("id") int
		 * id) { return bookServices.getBookByID(id); }
		 */
		
		
		// get single books handler
		@GetMapping("/book/{id}")						//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
		public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id) {
			Book book = bookServices.getBookByID(id);
			if(book==null) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
			}
			return ResponseEntity.of(Optional.of(book));
		}
	 
	//Add new book handler
	@PostMapping("/books1")								//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		Book b = null ;
		
		try {
			b = this.bookServices.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}
	
	//Delete new book handler
	@DeleteMapping("/books/{bookId}")					//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		
		try {
			this.bookServices.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	 * //Update book handler				//Using Simple return Book obj without try/catch and ResponseEntity<T>
	 * 
	 * @PutMapping("/books/{bookId}") public Book updateBook(@PathVariable("bookId")
	 * int bookId,@RequestBody Book book) { this.bookServices.updateBook(book,
	 * bookId); return book; }
	 */
	
	
	//Update book handler
	@PutMapping("/books/{bookId}")							//Using  return ResponseEntity<Book> obj with try/catch block data for error handling
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
		
		try {
			this.bookServices.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
