package me.bs.java.usermanagement.frontend.rest.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.bs.java.aop.annotation.Loggable;
import me.bs.java.aop.exception.IDNotFoundException;
import me.bs.java.usermanagement.backend.entity.UserEntity;
import me.bs.java.usermanagement.backend.service.UserService;
 
@RestController
@Loggable
@RequestMapping(path="/rest/user")
public class UserRestController {

	@Autowired
	UserService userService;
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	//@Loggable
	@RequestMapping(path="/", method=RequestMethod.GET)
	public Iterable<UserEntity> findAllUsers() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> findUserById(@PathVariable("id") Long id) throws IDNotFoundException {
		ResponseEntity<Object> response=null ;
		Optional<UserEntity> userEntity;

			userEntity =  userService.findById(id);
			response = new ResponseEntity<>(userEntity,HttpStatus.OK);

		return  response;
	}
	@RequestMapping(path="/", method=RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody  UserEntity userEntity) {
		UserEntity createdUserEntity = userService.save(userEntity);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUserEntity.getId()).toUri();

		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public UserEntity updateUser(@RequestBody  UserEntity userEntity) {
		
		return userService.save(userEntity);
	}
	
}
