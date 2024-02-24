package com.teclead.solution.model;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import org.springframework.data.annotation.Id;

@ExternalDocumentation
public record UserEntity(@Id Integer id, String givenName, String name, String email) {
}
