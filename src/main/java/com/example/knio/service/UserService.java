package com.example.knio.service;


import com.example.knio.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findById(String username);

    User save(User user);

    void deleteById(String username);

    User registerUser(User user);
}
