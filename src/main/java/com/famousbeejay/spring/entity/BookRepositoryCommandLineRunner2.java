package com.famousbeejay.spring.entity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BookRepositoryCommandLineRunner2 implements CommandLineRunner{

	
	private static final Logger log = 
			LoggerFactory.getLogger(BookRepositoryCommandLineRunner2.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Book book = new Book("My Awesome Book", "Book of Health", new Date());
		
		bookRepository.save(book);
		log.info("New book 2 is created : " + book);
		
		Optional<Book> retrieveBookOne = bookRepository.findById(1L);
		log.info("Book one is retrieved : " + retrieveBookOne);
		
		List<Book> allBooks = bookRepository.findAll();
		log.info("Retrieve all books : " + allBooks);
		
		
	}
}
