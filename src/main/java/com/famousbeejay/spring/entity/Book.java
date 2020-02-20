package com.famousbeejay.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	private String description;
	
	private Date publication;
	
	
	
	public Book() {
		super();
	}
	public Book(String title, String description, Date publication) {
		super();
		this.title = title;
		this.description = description;
		this.publication = publication;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getPublication() {
		return publication;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", publication=" + publication
				+ "]";
	}
	
	
	
}
