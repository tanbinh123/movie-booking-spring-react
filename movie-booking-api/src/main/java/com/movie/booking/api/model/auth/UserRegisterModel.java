package com.movie.booking.api.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.booking.api.entity.Person;
import com.movie.booking.api.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterModel extends Person {

    //Person contains : first_name, last_name, phone, address and email
    private String username;
    private String password;
    private Set<Role> roles;
}
