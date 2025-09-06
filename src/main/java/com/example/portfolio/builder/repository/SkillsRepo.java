package com.example.portfolio.builder.repository;

import com.example.portfolio.builder.model.Skills;
import com.example.portfolio.builder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillsRepo extends JpaRepository<Skills, Integer> {
    List<Skills> findByUserId(Integer id);
    Optional<Skills> findByIdAndUserId(Integer id, Integer userId);

}
