package com.famousbeejay.spring.entity;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BookDAOServiceCommandLineRunner implements CommandLineRunner{

	
	private static final Logger log = 
			LoggerFactory.getLogger(BookDAOServiceCommandLineRunner.class);
	
	@Autowired
	private BookDAOServices bookDAOServices;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Book book = new Book("My new Book", "Book of Life", new Date());
		long insert = bookDAOServices.insert(book);
		
		log.info("New book is created : " + book);
	}
}
