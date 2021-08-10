package com.movie.booking.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.booking.api.entity.Reservation;
import com.movie.booking.api.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

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
    private List<Reservation> reservations;
    private Collection<Role> roles;
}
