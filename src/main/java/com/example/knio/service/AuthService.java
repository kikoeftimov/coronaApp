package com.example.knio.service;


import com.example.knio.model.User;

public interface AuthService {

    User findUser();

    String getCurrentUsername();

    User signUpUser(String username, String password, String repeatedPassword, String email, String dateOfBirth);
}
