package com.movie.booking.api.service;

import com.movie.booking.api.entity.User;
import com.movie.booking.api.model.UserModel;
import com.movie.booking.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User customer = userRepository.findUserByUsername(username);
        if(customer==null){
            throw new UsernameNotFoundException("Customer not found");
        }
        return customer;
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public UserModel addUser(UserModel userModel){
        User user = userRepository.save(modelMapper.map(userModel, User.class));
        return modelMapper.map(userRepository.save(user), UserModel.class);
    }

    public Collection<UserModel> getUsers(){
        return Arrays.asList(modelMapper.map(userRepository.findAll(),UserModel[].class));
    }

    public void removeUser(Long id){
        userRepository.delete(userRepository.findById(id).get());
    }



}