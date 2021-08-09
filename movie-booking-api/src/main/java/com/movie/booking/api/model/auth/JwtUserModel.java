package com.movie.booking.api.model.auth;

import com.movie.booking.api.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtUserModel {
    private String token;
    private UserModel user;
}
