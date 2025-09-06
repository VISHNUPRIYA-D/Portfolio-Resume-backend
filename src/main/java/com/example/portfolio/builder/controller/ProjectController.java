package com.example.portfolio.builder.controller;


import com.example.portfolio.builder.dto.ProjectDTO;
import com.example.portfolio.builder.model.Project;
import com.example.portfolio.builder.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/projects")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping("/{id}")
    public List<ProjectDTO> findByUserId(@PathVariable Integer id){
        return service.findByUserId(id);
    }

    @PostMapping("/{id}")
    public ProjectDTO addProject(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO){
        return service.addProject(id,projectDTO);
    }

    @PutMapping("/{userId}/{projectId}")
    public ProjectDTO updateProject(@PathVariable Integer userId, @PathVariable Integer projectId, @RequestBody ProjectDTO projectDTO){
        return service.updateProject(userId,projectId,projectDTO);
    }
    @DeleteMapping("/{userId}/{projectId}")
    public void deleteProject(@PathVariable Integer userId, @PathVariable Integer projectId){
        service.deleteProject(userId,projectId);
    }

}
