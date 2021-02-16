package com.springbootproject.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.springbootproject.test.entities.Book;


@Component							//Here we can also use service
public class BookServices {
	
	//fake database as a api to store in program and retrieve it from bookservice using static 
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(123,"Java Complete Refrences","XYZ"));
		list.add(new Book(12,"Head First to Java ","ABC"));
		list.add(new Book(122,"Think in Java","LMN"));
	}
	
	//get all books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get single book by id
	public Book getBookByID(int id) {
		
		Book book = null;
		try {
			//Here we can use if conf,foreach also but we use stream of collection(Java 8)
			book = list.stream().filter(e-> e.getId() == id).findFirst().get();
		} catch (Exception e2) {
			e2.printStackTrace();
		}	
		return book;
	}
	
	//Adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//Delete Book
	public void deleteBook(int bId) {
		
		
		//First Mtdh to return data from filter in block of if else condition
		/*
		 * list=list.stream().filter(Book -> { if(Book.getId() != bId) { return true;
		 * }else { return false; } }).collect(Collectors.toList());
		 */
		
		//Second Mtdh to return data from filter in block of if else condition
		list=list.stream().filter(book ->book.getId() != bId).collect(Collectors.toList());
		
	}
	
	//Update Book
	public void updateBook(Book book,int bookId) {
		list=list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
