package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.SkillsDTO;
import com.example.portfolio.builder.model.Skills;
import org.springframework.stereotype.Component;


@Component
public class SkillsMapper {
    public SkillsDTO toDTO(Skills skills){
        if(skills!=null){
            SkillsDTO skillsDTO = new SkillsDTO();
            skillsDTO.setId(skills.getId());
            skillsDTO.setSkill(skills.getSkill());
            skillsDTO.setLevel( skills.getLevel() );
            return skillsDTO;
        }
        else return null;
    }
    public Skills toEntity(SkillsDTO skillsDTO){
        if(skillsDTO!=null){
            Skills skills = new Skills();
            skills.setId(skillsDTO.getId());
            skills.setSkill(skillsDTO.getSkill());
            skills.setLevel(skillsDTO.getLevel());
            return skills;

        }else return null;
    }

    public void updateEntity(Skills skills, SkillsDTO skillsDTO){
        if(skillsDTO.getSkill() != null )skills.setSkill(skillsDTO.getSkill());
        if(skillsDTO.getLevel() != null )skills.setLevel(skillsDTO.getLevel());
    }
}
