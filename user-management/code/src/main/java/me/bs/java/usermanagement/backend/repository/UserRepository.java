package me.bs.java.usermanagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import me.bs.java.usermanagement.backend.entity.UserEntity;

@Repository
@RepositoryRestResource(collectionResourceRel = "UserRepository"
, path = "UserRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
