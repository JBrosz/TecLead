package com.teclead.solution.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;

    private String givenName;

    private String name;

    private String email;

}
