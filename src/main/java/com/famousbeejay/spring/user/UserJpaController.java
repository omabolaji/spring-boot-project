package com.famousbeejay.spring.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.famousbeejay.spring.post.Post;


@RestController
public class UserJpaController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	//retrieve all users
	@GetMapping(path="/jpa/users")
	public List<User> retrieveAllUsers(){
		
		return userRepository.findAll();
	}
	
	//retrieve one user
	@GetMapping(path="/jpa/users/{id}")
	public Optional<User> retrieveSingleUser(@PathVariable int id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) 
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
	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
		User saveUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	//Update user
		//@RequestMapping(method= RequestMethod.PUT, path= "/users/{id}")
		@PutMapping(path= "/jpa/users/{id}")
	    public User updateUser(@PathVariable int id, @RequestBody User user) {
	        if (user.getId() != id) {
	          throw new UserExceptionHandler("id-"+ id);
	        }
	    Optional<User> userUpdate = userRepository.findById(id);
	  
	        return user;
	    }
		
	
	//delete user
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		 userRepository.deleteById(id);
	}
	
	
	//post url unit
	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id){
		
		Optional<User> userPost = userRepository.findById(id);
		if(!userPost.isPresent()) {
			throw new UserExceptionHandler("id-"+ id);
		}
		 
		return userPost.get().getPost();
	}
	
	//single post
	@GetMapping(path="/jpa/users/{id}/posts/{id}")
	public Optional<Post> retrieveSinglePost(@PathVariable int id){
		
		Optional<User> userPost = userRepository.findById(id);
		
		if(!userPost.isPresent()) {
			throw new UserExceptionHandler("id-"+ id);
		}
		 
		Optional<Post> myPost = postRepository.findById(id);
				
		if(!myPost.isPresent()) {
			throw new UserExceptionHandler("id-"+ id);
		}	
		
		return myPost;
	}

	
	//create post
	@PostMapping(path="/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userId = userRepository.findById(id);
		
		if(!userId.isPresent()) {
			throw new UserExceptionHandler("id-"+ id);
		}
		
		User user = userId.get();
		
		post.setUser(user);
		
		
		Post myNewPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
