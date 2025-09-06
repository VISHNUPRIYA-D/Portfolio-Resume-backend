package com.example.portfolio.builder.repository;

import com.example.portfolio.builder.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepo extends JpaRepository<Experience,Integer> {
    List<Experience> findByUserId(Integer userId);

    Optional<Experience> findByIdAndUserId(Integer id, Integer exId);
}
