package com.example.knio.service.impl;

import com.example.knio.model.Info;
import com.example.knio.model.User;
import com.example.knio.model.exceptions.UserNotFoundException;
import com.example.knio.repository.InfoRepository;
import com.example.knio.service.AuthService;
import com.example.knio.service.InfoService;
import com.example.knio.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    private final UserService userService;
    private final InfoRepository infoRepository;
    private final AuthService authService;

    public InfoServiceImpl(UserService userService, InfoRepository infoRepository, AuthService authService) {
        this.userService = userService;
        this.infoRepository = infoRepository;
        this.authService = authService;
    }

    @Override
    public Info findById(Long id) {
        return this.infoRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user"));
    }

    @Override
    public List<Info> findAll() {
        return this.infoRepository.findAll();
    }

    @Override
    public List<Info> findAllById(String username) {
        return this.infoRepository.findAllByUserUsername(username);
    }

    @Override
    public Info save(Info info) {
        User user = this.authService.findUser();
        info.setUser(user);
        return this.infoRepository.save(info);
    }
}
