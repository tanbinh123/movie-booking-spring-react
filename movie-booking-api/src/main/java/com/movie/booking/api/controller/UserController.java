package com.movie.booking.api.controller;

import com.movie.booking.api.model.MovieModel;
import com.movie.booking.api.model.UserModel;
import com.movie.booking.api.service.MovieService;
import com.movie.booking.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Collection<UserModel> getUsers (){
        return userService.getUsers();
    }

    @PostMapping
    public UserModel addUser(@RequestBody UserModel userModel){
        return userService.addUser(userModel);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
    }

}
