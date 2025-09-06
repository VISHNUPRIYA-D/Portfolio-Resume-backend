package com.example.portfolio.builder.controller;


import com.example.portfolio.builder.dto.SkillsDTO;
import com.example.portfolio.builder.model.Skills;
import com.example.portfolio.builder.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/skills")
public class SkillsController {

    @Autowired
    private SkillsService service;

    @GetMapping("/{id}")
    public List<SkillsDTO> getSkills(@PathVariable Integer id) {
        return service.getSkills(id);
    }

    @PostMapping("/{id}")
    public SkillsDTO addSkills(@PathVariable Integer id, @RequestBody SkillsDTO skillDTO) {
        return service.addSkills(id,skillDTO);
    }

    @PutMapping("/{userId}/{skillId}")
    public SkillsDTO updateSkill(@PathVariable Integer userId, @PathVariable Integer skillId, @RequestBody SkillsDTO skillDTO) {
        return service.updateskill(userId,skillId,skillDTO);
    }

    @DeleteMapping("/{userId}/{skillId}")
    public void  deleteSkills(@PathVariable Integer userId, @PathVariable Integer skillId) {
        service.deleteSkill(userId,skillId);
    }




}
