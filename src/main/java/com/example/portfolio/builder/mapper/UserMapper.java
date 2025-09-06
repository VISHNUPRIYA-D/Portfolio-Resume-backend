package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.*;
import com.example.portfolio.builder.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    private  final EducationMapper educationMapper;
    private final ContactMapper contactMapper;
    private  final SkillsMapper skillsMapper;
    private  final SocialMediaMapper socialMediaMapper;
    private final ProjectMapper projectMapper;
    private final ExperienceMapper experienceMapper;

    public UserMapper(EducationMapper educationMapper, ContactMapper contactMapper, SkillsMapper skillsMapper, SocialMediaMapper socialMediaMapper, ProjectMapper projectMapper, ExperienceMapper experienceMapper) {
        this.educationMapper = educationMapper;
        this.contactMapper = contactMapper;
        this.skillsMapper = skillsMapper;
        this.socialMediaMapper = socialMediaMapper;
        this.projectMapper = projectMapper;
        this.experienceMapper = experienceMapper;
    }


    public UserDTO toDTO(User user) {



        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());
        dto.setTitle(user.getTitle());
        dto.setAbout(user.getAbout());
        dto.setImage(user.getImage());

        // Map contacts
        if (user.getContacts() != null) {
            dto.setContacts(user.getContacts().stream()
                    .map(contactMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Map educations
        if (user.getEducations() != null) {
            dto.setEducations(user.getEducations().stream()
                    .map(educationMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Map experiences
        if (user.getExperiences() != null) {
            dto.setExperiences(user.getExperiences().stream()
                    .map(experienceMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Map projects
        if (user.getProjects() != null) {
            dto.setProjects(user.getProjects().stream()
                    .map(projectMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Map skills
        if (user.getSkills() != null) {
            dto.setSkills(user.getSkills().stream()
                    .map(skillsMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        // Map social media
        if (user.getSocialMedia() != null) {
            dto.setSocialMedia(user.getSocialMedia().stream()
                    .map(socialMediaMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setName(dto.getName());
        user.setTitle(dto.getTitle());
        user.setAbout(dto.getAbout());
        user.setImage(dto.getImage());

        // Map contacts
        if (dto.getContacts() != null) {
            user.setContacts(dto.getContacts().stream()
                    .map(contactMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        // Map educations
        if (dto.getEducations() != null) {
            user.setEducations(dto.getEducations().stream()
                    .map(educationMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        // Map experiences
        if (dto.getExperiences() != null) {
            user.setExperiences(dto.getExperiences().stream()
                    .map(experienceMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        // Map projects
        if (dto.getProjects() != null) {
            user.setProjects(dto.getProjects().stream()
                    .map(projectMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        // Map skills
        if (dto.getSkills() != null) {
            user.setSkills(dto.getSkills().stream()
                    .map(skillsMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        // Map social media
        if (dto.getSocialMedia() != null) {
            user.setSocialMedia(dto.getSocialMedia().stream()
                    .map(SocialMediaMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        return user;
    }
}
