package com.movie.booking.api.model.auth;

import com.movie.booking.api.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterModel {
    private String username;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
}
