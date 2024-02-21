package com.teclead.solution.model;

import org.springframework.data.annotation.Id;

public record UserEntity(@Id Integer id, String givenName, String name, String email) {
}
