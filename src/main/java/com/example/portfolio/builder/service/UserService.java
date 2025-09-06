package com.example.portfolio.builder.service;

import com.example.portfolio.builder.dto.UserDTO;
import com.example.portfolio.builder.mapper.UserMapper;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.UserRepo;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    // Get all users
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Add a new user
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepo.save(user);
        return userMapper.toDTO(savedUser);
    }

    // Find user by ID
    public List<UserDTO> findById(int id) {

        return userRepo.findById(id).stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    // Update an existing user
    public UserDTO updateUser(int id, UserDTO updatedUserDTO) {
        return userRepo.findById(id)
                .map(user -> {

                                if (updatedUserDTO.getName() != null) {
                                    user.setName(updatedUserDTO.getName());
                                }
                                if (updatedUserDTO.getTitle() != null) {
                                    user.setTitle(updatedUserDTO.getTitle());
                                }
                                if (updatedUserDTO.getAbout() != null) {
                                    user.setAbout(updatedUserDTO.getAbout());
                                }
                                if (updatedUserDTO.getImage() != null) {
                                    user.setImage(updatedUserDTO.getImage());
                                }
                    User savedUser = userRepo.save(user);
                    return userMapper.toDTO(savedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Delete a user
    public void deleteUser(int id) {

        userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found with id " + id));
        userRepo.deleteById(id);


    }
}
