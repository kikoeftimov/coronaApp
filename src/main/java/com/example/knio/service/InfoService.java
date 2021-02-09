package com.example.knio.service;

import com.example.knio.model.Info;

import java.util.List;

public interface InfoService {

    Info findById(Long id);

    List<Info> findAll();

    List<Info> findAllById(String username);

    Info save(Info info);
}
