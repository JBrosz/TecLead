package com.teclead.solution.repository;

import com.teclead.solution.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    UserEntity findByGivenName(String givenName);
}
