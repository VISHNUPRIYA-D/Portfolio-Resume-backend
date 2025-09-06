package com.example.portfolio.builder.controller;

import com.example.portfolio.builder.dto.EducationDTO;
import com.example.portfolio.builder.model.Education;
import com.example.portfolio.builder.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/educations")
public class EducationController {


    @Autowired
    private EducationService service;

   @GetMapping("/{id}")
    public List<EducationDTO> getEducationById(@PathVariable int id) {
        return service.getEducationById(id);
    }

   @PostMapping("/{id}")
   public EducationDTO addEducation(@PathVariable int id, @RequestBody EducationDTO educationDTO) {
       return service.addEducation(id,educationDTO);
   }

   @PutMapping("/{userId}/{educationId}")
    public EducationDTO updateEducation(@PathVariable int userId, @RequestBody EducationDTO educationDTO, @PathVariable int educationId) {
       return service.updateEducation(userId,educationDTO,educationId);
   }

   @DeleteMapping("/{userId}/{educationId}")
    public void deleteEducation(@PathVariable int userId,@PathVariable int educationId) {
       service.deleteEducation(userId,educationId);
   }

}
