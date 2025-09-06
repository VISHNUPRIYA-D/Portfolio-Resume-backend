package com.example.portfolio.builder.controller;

import com.example.portfolio.builder.dto.UserDTO;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.UserRepo;
import com.example.portfolio.builder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService service;


    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {

        return service.addUser(userDTO);
    }

    @GetMapping("/{id}")
    public List<UserDTO> getUserById(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable int id) {
       return service.updateUser(id,userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        System.out.println("deleted " + id);
    }
}