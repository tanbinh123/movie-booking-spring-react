package com.movie.booking.api.controller;

import com.movie.booking.api.entity.Role;
import com.movie.booking.api.model.MovieModel;
import com.movie.booking.api.model.UserModel;
import com.movie.booking.api.service.MovieService;
import com.movie.booking.api.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    //Request GET : /api/users/{id}
    @GetMapping
    public Collection<UserModel> getUsers (){
        return userService.getUsers();
    }

    //Request POST : /api/users
    @PostMapping
    public UserModel addUser(@RequestBody UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setRoles(Arrays.asList(Role.ROLE_USER));
        return userService.addUser(userModel);
    }

    //Request DELETE : /api/users/{id}
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
    }

}
