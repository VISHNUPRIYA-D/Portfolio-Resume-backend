package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.EducationDTO;
import com.example.portfolio.builder.model.Education;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {
    public EducationDTO toDTO(Education education) {
        if(education != null) {
            EducationDTO educationDTO = new EducationDTO();
            educationDTO.setId(education.getId());
            educationDTO.setSchoolName(education.getSchoolName());
            educationDTO.setCollegeName(education.getCollegeName());
            educationDTO.setField(education.getField());
            educationDTO.setStartDate(education.getStartDate());
            educationDTO.setEndDate(education.getEndDate());
            return educationDTO;
        }else return null;
    }

    public  Education toEntity(EducationDTO educationDTO) {
        if(educationDTO != null) {
            Education education = new Education();
            education.setId(educationDTO.getId());
            education.setSchoolName(educationDTO.getSchoolName());
            education.setCollegeName(educationDTO.getCollegeName());
            education.setField(educationDTO.getField());
            education.setStartDate(educationDTO.getStartDate());
            education.setEndDate(educationDTO.getEndDate());
            return education;
        }else return null;
    }

    public void updateEntity(Education education,EducationDTO educationDTO) {
        if(educationDTO.getSchoolName() != null) education.setSchoolName(educationDTO.getSchoolName());
        if(educationDTO.getCollegeName() != null) education.setCollegeName(educationDTO.getCollegeName());
        if(educationDTO.getField() != null) education.setField(educationDTO.getField());
        if(educationDTO.getStartDate() != null) education.setStartDate(educationDTO.getStartDate());
        if(educationDTO.getEndDate() != null) education.setEndDate(educationDTO.getEndDate());
    }

}
