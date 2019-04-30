package me.bs.java.usermanagement.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import me.bs.java.aop.exception.IDNotFoundException;
import me.bs.java.usermanagement.backend.entity.UserEntity;
import me.bs.java.usermanagement.backend.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Caching(
			evict= { 
					@CacheEvict(value= "userEntityCache", key= "#userEntity.id"),
					@CacheEvict(value= "allUserEntitiesCache", allEntries= true)
				   }
			
		)
	public void deleteById(Long id) throws IDNotFoundException {
		findById(id);
		userRepository.deleteById(id);
	}

	@Cacheable(value= "allUserEntitiesCache", unless= "#result.size() == 0")	
	public Iterable<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Cacheable(value= "userEntityCache", key= "#id")
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

	@Caching(
			put= { @CachePut(value= "userEntityCache", key= "#userEntity.id") },
			evict= { @CacheEvict(value= "allUserEntitiesCache", allEntries= true) }
		)
	public UserEntity save(UserEntity userEntity) throws IDNotFoundException {
		if (userEntity != null) {
			if (userEntity.getId() != null) {
				findById(userEntity.getId());
			}

		}

		return userRepository.save(userEntity);
	}

}
