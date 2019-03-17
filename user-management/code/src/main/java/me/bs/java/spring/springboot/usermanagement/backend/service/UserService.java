package me.bs.java.spring.springboot.usermanagement.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bs.java.spring.springboot.usermanagement.backend.entity.UserEntity;
import me.bs.java.spring.springboot.usermanagement.backend.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public Iterable<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<UserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public UserEntity save(UserEntity userEntity) {
		
		return userRepository.save(userEntity);
	}

	
	
	
}
