package com.example.knio.repository;

import com.example.knio.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

    List<Info> findAllByUserUsername(String username);
}
