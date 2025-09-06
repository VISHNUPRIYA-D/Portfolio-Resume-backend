package com.example.portfolio.builder.controller;

import com.example.portfolio.builder.dto.SocialMediaDTO;
import com.example.portfolio.builder.model.Socialmedia;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.UserRepo;
import com.example.portfolio.builder.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/socialmedia")
public class SocialMediaController {

    @Autowired
    private SocialMediaService service;


    @PostMapping("/{userId}")
    public SocialMediaDTO addSocialMedia(@PathVariable Integer userId, @RequestBody SocialMediaDTO socialMediaDTO) {
        return service.addSocialMedia(userId, socialMediaDTO);
    }

    @PutMapping("/{userId}/{socialMediaId}")
    public SocialMediaDTO updateSocialMedia(@PathVariable Integer userId,
                                         @PathVariable Integer socialMediaId,
                                         @RequestBody SocialMediaDTO socialMediaDTO) {
        return service.updateSocialMedia(userId, socialMediaId, socialMediaDTO);
    }

    @GetMapping("/{userId}")
    public List<SocialMediaDTO> getSocialMediaByUser(@PathVariable Integer userId) {
        return service.getSocialMediaByUser(userId);
    }

    @DeleteMapping("/{userId}/{socialMediaId}")
    public void deleteSocialMedia(@PathVariable Integer socialMediaId,@PathVariable Integer userId) {

        service.deleteSocialMedia(socialMediaId,userId);
    }
}
