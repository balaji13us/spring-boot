package me.bs.java.spring.springboot.usermanagement.frontend.rest.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.bs.java.spring.springboot.usermanagement.backend.entity.UserEntity;
import me.bs.java.spring.springboot.usermanagement.backend.service.UserService;
 
@RestController
@RequestMapping(path="/rest/user")
public class UserRestController {

	@Autowired
	UserService userService;
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public Iterable<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Optional<UserEntity> findById(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}
	@RequestMapping(path="/", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody  UserEntity userEntity) {
		UserEntity createdUserEntity = userService.save(userEntity);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUserEntity.getId()).toUri();

		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public UserEntity update(@RequestBody  UserEntity userEntity) {
		
		return userService.save(userEntity);
	}
	
}
