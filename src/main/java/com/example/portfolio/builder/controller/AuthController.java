package com.example.portfolio.builder.controller;

import com.example.portfolio.builder.dto.AuthResponse;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.UserRepo;
import com.example.portfolio.builder.request.SignupRequest;
import com.example.portfolio.builder.request.LoginRequest;
import com.example.portfolio.builder.security.JwtUtil;
import com.example.portfolio.builder.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // Generate token
            String token = jwtUtil.generateToken(loginRequest.getUsername());

            // Fetch user from DB
            User dbUser = userRepo.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Return token + userId + username
            return ResponseEntity.ok(new AuthResponse(token, dbUser.getUsername(),dbUser.getId()));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole("USER");

        userRepo.save(user);

        // Auto login: generate token
        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getId()));
    }

}

