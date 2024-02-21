package com.teclead.solution.util;

import com.teclead.solution.model.UserEntity;
import com.teclead.solution.model.User;

import java.util.Optional;

public class UserMapper {

    public static User toUser(Optional<UserEntity> optionalUserEntityentity) {
        UserEntity entity = optionalUserEntityentity.get();
        return new User(entity.id(), entity.givenName(), entity.name(), entity.email());
    }

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getGivenName(), user.getName(), user.getEmail());
    }
}
