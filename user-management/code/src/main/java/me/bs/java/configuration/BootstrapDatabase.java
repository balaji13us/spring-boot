package me.bs.java.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.bs.java.usermanagement.backend.entity.AddressEntity;
import me.bs.java.usermanagement.backend.entity.PhoneEntity;
import me.bs.java.usermanagement.backend.entity.UserEntity;
import me.bs.java.usermanagement.backend.repository.AddressRepository;
import me.bs.java.usermanagement.backend.repository.PhoneRepository;
import me.bs.java.usermanagement.backend.repository.UserRepository;
@Component
public class BootstrapDatabase {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	AddressRepository addressRepository;
	
	@PostConstruct
	public void insertUserData()
	{
		System.out.println("BootstrapDatabase.insertData");
		List<UserEntity> userEntityList = new ArrayList<UserEntity>();
		List<AddressEntity> addressEntityList = new ArrayList<AddressEntity>();
		List<PhoneEntity> phoneEntityList = new ArrayList<PhoneEntity>();
		UserEntity userEntity=null;
		AddressEntity addressEntity = null;;
		PhoneEntity phoneEntity =null;
		
		// User 1
		userEntity = new UserEntity( "", null,"Michael", "Fox", "Michael Fox", "Fox@abc.com", null, null);
		userEntity = userRepository.save(userEntity);
		userEntityList.add(userEntity);

		phoneEntity = new PhoneEntity( "", true, "home", "2536525896", userEntity);
		phoneEntity = phoneRepository.save(phoneEntity);
		
		phoneEntity = new PhoneEntity( "", true, "mobile", "75444444444", userEntity);
		phoneEntity = phoneRepository.save(phoneEntity);

		addressEntity = new AddressEntity("", true, "home", "line 1", "line 2", "line 3", null, null, "Chennai", "TN", "012542", "INDIA", userEntity);
		addressEntity = addressRepository.save(addressEntity);

		addressEntity = new AddressEntity("", true, "office", "line 1", "line 2", "line 3", null, null, "Bangalore", "KA", "234324", "INDIA", userEntity);
		addressEntity = addressRepository.save(addressEntity);
		
		// User 2
		userEntity = new UserEntity( "", null,"James", "Fox", "James Fox", "James.Fox@abc.com", null, null);
		userEntity = userRepository.save(userEntity);
		userEntityList.add(userEntity);

		// User 3
		userEntity = new UserEntity( "", null,"Jamy", "Fox", "Jamy Fox", "Jamy.Fox@abc.com", null, null);
		userEntity = userRepository.save(userEntity);
		userEntityList.add(userEntity);
		
	}
	
	
	
}
