package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.ProjectDTO;
import com.example.portfolio.builder.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectDTO toDTO(Project project){
        if(project!=null){
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setId(project.getId());
            projectDTO.setTitle(project.getTitle());
            projectDTO.setDescription(project.getDescription());
            projectDTO.setTech(project.getTech());
            projectDTO.setLink(project.getLink());
            return projectDTO;
        }else return null;
    }

    public  Project toEntity(ProjectDTO projectDTO){
        if(projectDTO!=null){
            Project project = new Project();
            project.setId(projectDTO.getId());
            project.setTitle(projectDTO.getTitle());
            project.setDescription(projectDTO.getDescription());
            project.setTech(projectDTO.getTech());
            project.setLink(projectDTO.getLink());
            return project;

        }else return null;
    }

    public void updateEntity(Project  project, ProjectDTO projectDTO){
        if(projectDTO.getTitle()!=null)project.setTitle(projectDTO.getTitle());
        if(projectDTO.getDescription()!=null)project.setDescription(projectDTO.getDescription());
        if(projectDTO.getTech()!=null)project.setTech(projectDTO.getTech());
        if(projectDTO.getLink()!=null)project.setLink(projectDTO.getLink());
    }
}
