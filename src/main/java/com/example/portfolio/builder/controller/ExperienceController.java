package com.example.portfolio.builder.controller;

import com.example.portfolio.builder.dto.ExperienceDTO;
import com.example.portfolio.builder.model.Experience;
import com.example.portfolio.builder.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/experiences")
public class ExperienceController {
    @Autowired
    ExperienceService service;

    @GetMapping("/{id}")
    public List<ExperienceDTO> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/{id}")
    public ExperienceDTO addExperience(@RequestBody ExperienceDTO experienceDTO, @PathVariable int id) {
       return  service.addExperience(id,experienceDTO);
    }


    @PutMapping("/{userId}/{exId}")
    public ExperienceDTO updateExperience(@RequestBody ExperienceDTO experienceDTO, @PathVariable int userId, @PathVariable int exId) {
        return service.updateExperience(userId,experienceDTO,exId);
    }

    @DeleteMapping("/{userId}/{exId}")
    public void deleteExperience(@PathVariable int userId, @PathVariable int exId) {
        service.deleteById(userId,exId);
    }
}
