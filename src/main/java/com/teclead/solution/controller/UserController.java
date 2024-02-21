package com.teclead.solution.controller;

import com.teclead.solution.model.User;
import com.teclead.solution.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Endpoint for creating a user
    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    // Endpoint for retrieving a user by ID
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return service.getUserById(userId);
    }

    // Endpoint for updating a user
    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }

    // Endpoint for deleting a user by ID
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        service.deleteUser(userId);
    }

    // Endpoint for retrieving all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    public ResponseEntity<User> getUserByEmail(String email) {
        return new ResponseEntity<>(this.service.getUserByEmail(email), HttpStatus.ACCEPTED);
    }
}
