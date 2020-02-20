package com.famousbeejay.spring.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository //database repo
@Transactional //talking to database
public class BookDAOServices {

	@PersistenceContext //to reflect/tracking a new change to the database
	private EntityManager entityManager;
	
	public long insert(Book book) {
		entityManager.persist(book);
		return book.getId();
	}
}
