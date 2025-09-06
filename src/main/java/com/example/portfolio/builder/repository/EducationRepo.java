package com.example.portfolio.builder.repository;

import com.example.portfolio.builder.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepo extends JpaRepository<Education,Integer> {
    List<Education> findByUserId(Integer userId);
    Optional<Education> findByIdAndUserId(Integer id, Integer userId);
}
