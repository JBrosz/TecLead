package com.teclead.solution.service;


import com.teclead.solution.exception.UserNotFoundException;
import com.teclead.solution.model.User;
import com.teclead.solution.model.UserEntity;
import com.teclead.solution.repository.UserRepository;
import com.teclead.solution.util.UserMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
@Service
public class UserService {
    UserRepository repository;
    public UserEntity createUser(User user) {
        return repository.save(UserMapper.toEntity(user));
    }
    public User getUserById(int userId) throws UserNotFoundException {
        Optional<UserEntity> entity = repository.findById(userId);
        if (entity.isPresent())
            return UserMapper.toUser(entity.get());
        else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }
    public User getUserByEmail(String email) throws UserNotFoundException {
        Optional<UserEntity> entity = repository.findByEmail(email);
        if (entity.isPresent())
            return UserMapper.toUser(entity.get());
        else {
            throw new UserNotFoundException("User not found with email: " + email);
        }
    }
    public List<User> getAllUsers() {
        return Streamable.of(repository.findAll())
                .stream()
                .map(UserMapper::toUser)
                .toList();
    }
    public void updateUser(int userId) throws UserNotFoundException {
        Optional<UserEntity> entity = repository.findById(userId);
        if (entity.isPresent()){
            repository.save(entity.get());
        }else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }
    public void deleteUser(int userId) {
        repository.deleteById(userId);
    }
}
