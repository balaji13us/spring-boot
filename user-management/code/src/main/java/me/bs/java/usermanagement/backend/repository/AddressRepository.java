package me.bs.java.usermanagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import me.bs.java.usermanagement.backend.entity.AddressEntity;

@Repository
@RepositoryRestResource(collectionResourceRel = "AddressRepository", path = "AddressRepository")
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
