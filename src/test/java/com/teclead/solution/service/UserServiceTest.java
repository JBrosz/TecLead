package com.teclead.solution.service;

import com.teclead.solution.exception.UserNotFoundException;
import com.teclead.solution.model.User;
import com.teclead.solution.model.UserEntity;
import com.teclead.solution.repository.UserRepository;
import com.teclead.solution.util.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    private User userMock = mock(User.class);
    private final int testId = 13;
    private final String testGivenName = "Fiete";
    private final String testName = "Komporski";
    private final String testMail = "fiete@teclead.super";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize annotated fields
    }
    @Test
    void createUser() {
        when(repository.save(any(UserEntity.class))).thenReturn(new UserEntity(testId,testGivenName,testName,testMail));

        UserEntity response = userService.createUser(userMock);

        assertEquals(testId, response.id());
        assertEquals(testGivenName, response.givenName());
        assertEquals(testName, response.name());
        assertEquals(testMail, response.email());
    }
    @Test
    void getUserById_withTestId_UserFound() throws UserNotFoundException {
        when(repository.findById(testId)).thenReturn(Optional.of(new UserEntity(testId, testGivenName, testName, testMail)));

        User response = userService.getUserById(testId);

        assertEquals(testId, response.getId());
    }
    @Test
    void getUserById_withDifferentTestId_UserNotFoundException() throws UserNotFoundException {
        when(repository.findById(testId)).thenReturn(Optional.of(new UserEntity(testId, testGivenName, testName, testMail)));

        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(testId+1);
        });
    }
    @Test
    void getAllUsersByGivenName_TwoUsersProvided_ReturnsBoth() throws UserNotFoundException {
        UserEntity user1 = createUserEntity(testId, testGivenName, testName, testMail);
        UserEntity user2 = createUserEntity(testId + 1, testGivenName, "Atreides", testMail);
        List<UserEntity> userList = Arrays.asList(user1, user2);
        when(repository.getAllUsersByGivenName(testGivenName)).thenReturn(userList);

        List<User> response = userService.getAllUsersByGivenName(testGivenName);

        assertEquals(2, response.size());
        assertEquals(testGivenName, response.get(0).getGivenName());
        assertEquals(testGivenName, response.get(1).getGivenName());
    }
    @Test
    void getAllUsersByGivenName_NoSuchUser_UserNotFoundException() throws UserNotFoundException {
        when(repository.getAllUsersByGivenName(testGivenName)).thenReturn(Collections.emptyList());

        List<User> response = userService.getAllUsersByGivenName(testGivenName);

        assertTrue(response.isEmpty());
    }
    @Test
    void updateUser_UpdateName_CorrectUserName() throws UserNotFoundException {
         UserEntity userEntity = createUserEntity(testId, testGivenName, testName, testMail);
         User updatedUser = new User(testId, testGivenName, "Atreides", testMail);
         when(repository.findById(testId)).thenReturn(Optional.of(userEntity));

         userService.updateUser(updatedUser);

         verify(repository).save(argThat(entity ->
                 entity.id() == updatedUser.getId() &&
                         entity.givenName().equals(updatedUser.getGivenName()) &&
                         entity.name().equals(updatedUser.getName()) &&
                         entity.email().equals(updatedUser.getEmail())
         ));
    }
    @Test
    void updateUser_NoSuchUser_UserNotFoundException() throws UserNotFoundException {
        UserEntity userEntity = createUserEntity(testId, testGivenName, testName, testMail);
        User updatedUser = new User(testId, testGivenName, "Atreides", testMail);
        when(repository.findById(testId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {
            userService.updateUser(updatedUser);;
        });
    }
    @Test
    void deleteUser_UserExists_UserIsDeleted() {
        userService.deleteUser(testId);

        verify(repository).deleteById(testId);
    }
    @Test
    void deleteUser_UserNotExists_NoUserFound() {
        assertThrows(UserNotFoundException.class, () -> {
            userService.deleteUser(testId);
        });
    }
    private UserEntity createUserEntity(int id, String givenName, String name, String email) {
        return new UserEntity(id, givenName, name, email);
    }
}
