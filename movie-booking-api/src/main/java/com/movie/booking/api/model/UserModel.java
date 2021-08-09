package com.movie.booking.api.model;

import com.movie.booking.api.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Set<String> roles = new HashSet<>();

    public UserModel(Long id, String username, String email, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
