package com.movie.booking.api.controller;

import com.movie.booking.api.entity.Role;
import com.movie.booking.api.entity.User;
import com.movie.booking.api.model.auth.JwtUserModel;
import com.movie.booking.api.model.auth.UserLoginModel;
import com.movie.booking.api.model.UserModel;
import com.movie.booking.api.model.auth.UserRegisterModel;
import com.movie.booking.api.repository.RoleRepository;
import com.movie.booking.api.repository.UserRepository;
import com.movie.booking.api.security.JwtUtils;
import com.movie.booking.api.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginModel userLoginModel) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginModel.getUsername(), userLoginModel.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toSet());

        return ResponseEntity.ok(
                new JwtUserModel(
                        jwt,
                        new UserModel(
                            userDetails.getId(),
                            userDetails.getUsername(),
                            userDetails.getEmail(),
                            roles
                        )
                )
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterModel userRegisterModel) {
        if (userRepository.existsByUsername(userRegisterModel.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(userRegisterModel.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account
        User user = modelMapper.map(userRegisterModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterModel.getPassword()));
        Set<Role> roles = userRegisterModel.getRoles().stream()
                .map(item -> roleRepository.findByName(item.toUpperCase()).orElse(null))
                .collect(Collectors.toSet());

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

}
