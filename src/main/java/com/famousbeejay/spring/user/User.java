package com.famousbeejay.spring.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.famousbeejay.spring.post.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All deatils about users")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, message= "user name should have atleast 2 character")
	@ApiModelProperty(notes="User name should have atleast 2 character")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthday should be in the past")
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> post;
	
	protected User() {}
	
	public User(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return String.format("User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]");
	}
	
	

}
