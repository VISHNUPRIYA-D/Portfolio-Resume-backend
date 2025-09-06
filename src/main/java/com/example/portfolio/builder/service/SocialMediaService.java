package com.example.portfolio.builder.service;

import com.example.portfolio.builder.dto.SocialMediaDTO;
import com.example.portfolio.builder.mapper.SocialMediaMapper;
import com.example.portfolio.builder.model.Socialmedia;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.SocialMediaRepo;
import com.example.portfolio.builder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocialMediaService {

    @Autowired
    private  SocialMediaRepo socialMediaRepo;
    @Autowired
    private final SocialMediaMapper socialMediaMapper;

    private final UserRepo userRepo;

    public SocialMediaService(SocialMediaRepo socialMediaRepo, SocialMediaMapper socialMediaMapper, UserRepo userRepo) {
        this.socialMediaRepo = socialMediaRepo;
        this.socialMediaMapper = socialMediaMapper;
        this.userRepo = userRepo;
    }

    public SocialMediaDTO addSocialMedia(Integer userId, SocialMediaDTO socialMediaDTO) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Socialmedia socialmedia = socialMediaMapper.toEntity(socialMediaDTO);
        socialmedia.setUser(user);
        return socialMediaMapper.toDTO(socialMediaRepo.save(socialmedia));

    }

    public SocialMediaDTO updateSocialMedia(Integer userId, Integer socialMediaId, SocialMediaDTO socialMediaDTO) {
      Socialmedia socialmedia = socialMediaRepo.findByIdAndUserId(socialMediaId,userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SocialMedia Not Found"));
      socialMediaMapper.updateEntity(socialmedia,socialMediaDTO);
      return socialMediaMapper.toDTO(socialMediaRepo.save(socialmedia));
    }

    public List<SocialMediaDTO> getSocialMediaByUser(Integer userId) {
        return socialMediaRepo.findByUserId(userId).stream().map(socialMediaMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteSocialMedia(Integer socialMediaId, Integer userId) {
       Socialmedia socialmedia = socialMediaRepo.findById(socialMediaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SocialMedia Not Found"));
       if(socialmedia.getUser().getId() != userId){
           throw new RuntimeException("SocialMedia Not Found");
       }
       socialMediaRepo.delete(socialmedia);
    }
}
