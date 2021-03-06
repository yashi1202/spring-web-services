package com.example.rest.webservices.restfulwebservices.user;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder; 


/**
 * ResponseEntity is basically a extension of HTTP entity that adds a {@link HttpStatus} status code back.
 * */
@RestController
public class UserResource {
	//GET /users
	//retrieveAllUsers
	@Autowired
	private UserDaoService service;
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//GET /users/{id}
	@GetMapping("/users/{id}") 
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);//to user-friendliness we are using UserNotFoundException
			                                          //because if a user gives an anonymous userId it will show 
			                                          //OK status. But problem is not internal server error.
		}
		return user;
		
	}
	@DeleteMapping("/users/{id}") 
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);//to user-friendliness we are using UserNotFoundException
			                                          //because if a user gives an anonymous userId it will show 
			                                          //OK status. But problem is not internal server error.
		}
		
		
	}
	//CREATED
	//input - details of user
	//output - created & return the created URI
	//after using @RequestBody on a parameter, what would happen is, whatever we could pass
	//in the body of the request would be mapped to this parameter. If we are passing a birth date, 
	//that gets mapped to the birth date in here.
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User user) {
		User savedUser = service.save(user);
		//CREATED
		// /user/{id}    savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}

}
