package com.example.portfolio.builder.repository;


import com.example.portfolio.builder.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
    List<Project> findByUserId(Integer id);
    Optional<Project> findByIdAndUserId(Integer id, Integer userId);
}
