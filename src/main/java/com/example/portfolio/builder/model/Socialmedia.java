package com.example.portfolio.builder.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "socialMedia")
public class Socialmedia {
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String platform;
    private String url;

}
