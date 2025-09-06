package com.example.portfolio.builder.repository;

import com.example.portfolio.builder.model.Socialmedia;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SocialMediaRepo extends JpaRepository<Socialmedia, Integer> {
    List<Socialmedia> findByUserId(Integer userId);
    Optional<Socialmedia> findByIdAndUserId(Integer id,Integer userId);
}
