package com.famousbeejay.spring.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserController {

	@Autowired
	private UserDaoService service;
	
	//retrieve all users
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		
		return service.findAll();
	}
	
	//retrieve one user
	@GetMapping(path="/users/{id}")
	public User retrieveSingleUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		
		if (user == null) 
			throw new UserExceptionHandler("id-"+ id);
		
		//Resources<User>
//		@SuppressWarnings("deprecation")
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass())
//				.retrieveAllUsers());
				//.withRel("all-users");
		
		//ControllerLinkBuilder link = 
		
		return user;
	}
	

	//create new user
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
		User saveUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	//Update user
		//@RequestMapping(method= RequestMethod.PUT, path= "/users/{id}")
		@PutMapping(path= "/users/{id}")
	    public User updateUser(@PathVariable int id, @RequestBody User user) {
	        if (user.getId() != id) {
	          throw new UserExceptionHandler("id-"+ id);
	        }
	        service.findOne(id);
	  
	        return service.update(id, user);
	    }
		
	
	//delete user
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable int id) {
		
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserExceptionHandler("id-"+ id);
		}
		return user;
	}
	
}
