package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.ExperienceDTO;
import com.example.portfolio.builder.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper {
    public ExperienceDTO toDTO(Experience experience) {
        if(experience != null) {
            ExperienceDTO experienceDTO = new ExperienceDTO();
            experienceDTO.setId(experience.getId());
            experienceDTO.setCompanyName(experience.getCompanyName());
            experienceDTO.setRole(experience.getRole());
            experienceDTO.setDescription(experience.getDescription());
            experienceDTO.setStartDate(experience.getStartDate());
            experienceDTO.setEndDate(experience.getEndDate());
            return experienceDTO;
        }else return null;
    }

    public Experience toEntity(ExperienceDTO experienceDTO) {
        if(experienceDTO != null) {
            Experience experience = new Experience();
            experience.setId(experienceDTO.getId());
            experience.setCompanyName(experienceDTO.getCompanyName());
            experience.setRole(experienceDTO.getRole());
            experience.setDescription(experienceDTO.getDescription());
            experience.setStartDate(experienceDTO.getStartDate());
            experience.setEndDate(experienceDTO.getEndDate());
            return experience;

        }else return null;
    }

    public void updateEntity(Experience experience, ExperienceDTO experienceDTO) {
        if (experienceDTO.getCompanyName() != null) experience.setCompanyName(experienceDTO.getCompanyName());
        if (experienceDTO.getRole() != null) experience.setRole(experienceDTO.getRole());
        if (experienceDTO.getDescription() != null) experience.setDescription(experienceDTO.getDescription());
        if (experienceDTO.getStartDate() != null) experience.setStartDate(experienceDTO.getStartDate());
        if (experienceDTO.getEndDate() != null) experience.setEndDate(experienceDTO.getEndDate());
    }
}
