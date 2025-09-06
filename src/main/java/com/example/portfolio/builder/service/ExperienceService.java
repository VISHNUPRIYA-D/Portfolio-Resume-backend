package com.example.portfolio.builder.service;

import com.example.portfolio.builder.dto.ExperienceDTO;
import com.example.portfolio.builder.mapper.ExperienceMapper;
import com.example.portfolio.builder.model.Contact;
import com.example.portfolio.builder.model.Experience;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.EducationRepo;
import com.example.portfolio.builder.repository.ExperienceRepo;
import com.example.portfolio.builder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ExperienceService {
    @Autowired
    private final ExperienceRepo experienceRepo;

    private final ExperienceMapper experienceMapper;

    private final UserRepo userRepo;

    public ExperienceService(ExperienceRepo experienceRepo, ExperienceMapper experienceMapper, UserRepo userRepo) {
        this.experienceRepo = experienceRepo;
        this.experienceMapper = experienceMapper;

        this.userRepo = userRepo;
    }

    public List<ExperienceDTO> findById(int id) {
       return experienceRepo.findByUserId(id).stream().map(experienceMapper::toDTO).collect(Collectors.toList());
}

    public ExperienceDTO addExperience(int id, ExperienceDTO experienceDTO) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Experience experience = experienceMapper.toEntity(experienceDTO);
        experience.setUser(user);
        Experience savedExperience = experienceRepo.save(experience);
        return experienceMapper.toDTO(savedExperience);
    }

    public ExperienceDTO updateExperience(int id, ExperienceDTO experienceDTO, int exId) {

       Experience experience = experienceRepo.findByIdAndUserId(exId,id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Experience Not Found"));
       experienceMapper.updateEntity(experience,experienceDTO);
       return experienceMapper.toDTO(experienceRepo.save(experience));

    }

    public void deleteById(int userId, int exId) {

            Experience experience = experienceRepo.findById(exId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Experience not found"));
            if(experience.getUser().getId() != userId) {
                throw new RuntimeException("This experience does not belong to the user");
            }
            experienceRepo.delete(experience);
    }
}
