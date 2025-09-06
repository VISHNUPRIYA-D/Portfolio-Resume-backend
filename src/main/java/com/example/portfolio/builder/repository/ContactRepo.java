package com.example.portfolio.builder.repository;

import com.example.portfolio.builder.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
    List<Contact> findByUserId(Integer userId);
    Optional<Contact> findByIdAndUserId(Integer id, Integer userId);  // 👈 add this
}
