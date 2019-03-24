package me.bs.java.usermanagement.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bs.java.aop.exception.IDNotFoundException;
import me.bs.java.usermanagement.backend.entity.UserEntity;
import me.bs.java.usermanagement.backend.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void deleteById(Long id) throws IDNotFoundException {
		findById(id);
		userRepository.deleteById(id);
	}

	public Iterable<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<UserEntity> findById(Long id) throws IDNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntity = userRepository.findById(id);
		if (null == userEntity || !userEntity.isPresent()) {
			// System.out.println("ID not found");
			throw new IDNotFoundException("USER_ID_NOT_FOUND");
		} else {
			// System.out.println("ID found "+ userEntity);
		}

		return userEntity;
	}

	public UserEntity save(UserEntity userEntity) throws IDNotFoundException {
		if (userEntity != null) {
			if (userEntity.getId() != null) {
				findById(userEntity.getId());
			}

		}

		return userRepository.save(userEntity);
	}

}
