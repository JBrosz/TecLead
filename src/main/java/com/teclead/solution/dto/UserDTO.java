package com.teclead.solution.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String givenName;
    private String name;
    private String email;
}
