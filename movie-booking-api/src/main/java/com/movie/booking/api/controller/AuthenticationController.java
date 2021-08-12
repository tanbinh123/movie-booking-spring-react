package com.movie.booking.api.controller;

import com.movie.booking.api.entity.Role;
import com.movie.booking.api.entity.User;
import com.movie.booking.api.model.UserModel;
import com.movie.booking.api.model.auth.JwtUserModel;
import com.movie.booking.api.model.auth.UserLoginModel;
import com.movie.booking.api.model.auth.UserRegisterModel;
import com.movie.booking.api.repository.UserRepository;
import com.movie.booking.api.security.JwtUtils;
import com.movie.booking.api.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginModel userLoginModel) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginModel.getUsername(), userLoginModel.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User user = modelMapper.map(authentication.getPrincipal(), User.class);
        return ResponseEntity.ok(new JwtUserModel(jwt, modelMapper.map(user, UserModel.class)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterModel userRegisterModel) {
        if (userService.existsByUsername(userRegisterModel.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userService.existsByEmail(userRegisterModel.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        UserModel user = modelMapper.map(userRegisterModel, UserModel.class);
        user.setPassword(passwordEncoder.encode(userRegisterModel.getPassword()));
        user.setRoles(Arrays.asList(Role.ROLE_USER));
        return ResponseEntity.ok(userService.addUser(user));
    }

}
