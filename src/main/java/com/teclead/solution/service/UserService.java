package com.teclead.solution.service;


import com.teclead.solution.model.User;
import com.teclead.solution.model.UserEntity;
import com.teclead.solution.repository.UserRepository;
import com.teclead.solution.util.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.*;

import java.util.List;
@Service
public class UserService {

    UserRepository repository;
    public User getUserByEmail(String email) {

        return UserMapper.toUser(repository.findByEmail(email));
    }

    public void deleteUser(int userId) {
    }

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    public void updateUser(User user) {
    }

    public User getUserById(int userId) {
        return UserMapper.toUser(repository.findById(userId));
    }

    public void createUser(User user) {
    }
}
