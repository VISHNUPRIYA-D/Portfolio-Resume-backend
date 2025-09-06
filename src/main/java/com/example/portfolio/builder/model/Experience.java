package com.example.portfolio.builder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Experience")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Experience {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String companyName;
    private String role;
    private String description;
    private Date startDate;
    private Date endDate;


}
