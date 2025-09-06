package com.example.portfolio.builder.dto;

import lombok.Data;

@Data
public class AuthResponse {

    private String token;
    private String username;
    private int userId;



    public AuthResponse(String token, String username, int userId) {
        this.token = token;
        this.username = username;
        this.userId = userId;
    }
}

