package com.teclead.solution.service;

import com.teclead.solution.exception.UserNotFoundException;
import com.teclead.solution.model.User;
import com.teclead.solution.model.UserEntity;
import com.teclead.solution.repository.UserRepository;
import com.teclead.solution.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @PostMapping("create")
    public UserEntity createUser(@RequestBody User user) {
        return repository.save(UserMapper.toEntity(user));
    }

    @GetMapping("all")
    public List<User> getAllUsers() {
        return Streamable.of(repository.findAll())
                .stream()
                .map(UserMapper::toUser)
                .toList();
    }

    @GetMapping("byId/{userId}")
    public User getUserById(@PathVariable int userId) throws UserNotFoundException {
        Optional<UserEntity> entity = repository.findById(userId);
        if (entity.isPresent())
            return UserMapper.toUser(entity.get());
        else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    @GetMapping("allByGivenName")
    public List<User> getAllUsersByGivenName(@RequestParam String givenName) throws UserNotFoundException {
            return Streamable.of(repository.getAllUsersByGivenName(givenName))
                    .stream()
                    .map(UserMapper::toUser)
                    .toList();
    }

    @PutMapping("update")
    public void updateUser(@RequestBody User user) throws UserNotFoundException {
        Optional<UserEntity> entity = repository.findById(user.getId());
        if (entity.isPresent()){
            UserEntity updatedEntity = UserMapper.toEntity(user);
            repository.save(updatedEntity);
        } else {
            throw new UserNotFoundException("User not found with id: " + user.getId());
        }
    }

    @DeleteMapping("deleteById/{userId}")
    public void deleteUser(@PathVariable int userId) {
        repository.deleteById(userId);
    }
}
