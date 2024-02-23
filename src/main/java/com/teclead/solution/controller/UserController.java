package com.teclead.solution.controller;

import com.teclead.solution.exception.UserNotFoundException;
import com.teclead.solution.model.User;
import com.teclead.solution.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void createUser(User user) {
        service.createUser(user);
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    @GetMapping("/by givenName")
    public List<User> getAllUsersByGivenName(String givenName) throws UserNotFoundException {
        return service.getAllUsersByGivenName(givenName);
    }
    @GetMapping("/by Id")
    public User getUserById(@PathVariable int userId) throws UserNotFoundException {
        return service.getUserById(userId);
    }
    @PutMapping("")
    public void updateUser(User user) throws UserNotFoundException {
        service.updateUser(user);
    }
    @DeleteMapping("/by Id")
    public void deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
    }
}
