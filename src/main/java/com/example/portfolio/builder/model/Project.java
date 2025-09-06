package com.example.portfolio.builder.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "project")
public class Project {

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String Title;
    private String Description;
    private  String Tech;
    private String Link;
}
