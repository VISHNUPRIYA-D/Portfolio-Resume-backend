package com.example.portfolio.builder.service;

import com.example.portfolio.builder.dto.ProjectDTO;
import com.example.portfolio.builder.mapper.ProjectMapper;
import com.example.portfolio.builder.model.Project;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.ExperienceRepo;
import com.example.portfolio.builder.repository.ProjectRepo;
import com.example.portfolio.builder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private final ProjectRepo projectRepo;

    @Autowired
    private final ProjectMapper projectMapper;

    private final UserRepo userRepo;


    public ProjectService(ProjectRepo projectRepo, ProjectMapper projectMapper, UserRepo userRepo) {
        this.projectRepo = projectRepo;
        this.projectMapper = projectMapper;
       this.userRepo = userRepo;
    }

    public ProjectDTO addProject(int id, ProjectDTO projectDTO) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

            Project project = projectMapper.toEntity(projectDTO);
            project.setUser(user);

            return projectMapper.toDTO(projectRepo.save(project));

    }

    public List<ProjectDTO> findByUserId(int id) {
        return projectRepo.findByUserId(id).stream().map(projectMapper::toDTO).collect(Collectors.toList());
    }

    public ProjectDTO updateProject(int userId, int projectId, ProjectDTO projectDTO) {
       Project project = projectRepo.findByIdAndUserId(projectId, userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Not Found"));
        projectMapper.updateEntity(project,projectDTO);
        return projectMapper.toDTO(projectRepo.save(project));
    }

    public void deleteProject(int userId, int projectId) {
       Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        if(project.getUser().getId() != userId){
            throw new RuntimeException("No such Project");
        }
       projectRepo.delete(project);

    }
}
