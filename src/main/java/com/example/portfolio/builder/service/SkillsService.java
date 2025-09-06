package com.example.portfolio.builder.service;


import com.example.portfolio.builder.dto.SkillsDTO;
import com.example.portfolio.builder.mapper.SkillsMapper;
import com.example.portfolio.builder.model.Project;
import com.example.portfolio.builder.model.Skills;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.SkillsRepo;
import com.example.portfolio.builder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillsService {

    @Autowired
    private final SkillsRepo skillsRepo;

    private final SkillsMapper skillsMapper;

    private final UserRepo userRepo;

    public SkillsService(SkillsRepo skillsRepo, SkillsMapper skillsMapper, UserRepo userRepo) {
        this.skillsRepo = skillsRepo;
        this.skillsMapper = skillsMapper;
        this.userRepo = userRepo;
    }


    public List<SkillsDTO> getSkills(int id) {
        return skillsRepo.findByUserId(id).stream().map(skillsMapper::toDTO).collect(Collectors.toList());
    }

    public SkillsDTO addSkills(int id, SkillsDTO skillDTO) {
        User user = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        Skills skills = skillsMapper.toEntity(skillDTO);
        skills.setUser(user);
        return skillsMapper.toDTO(skillsRepo.save(skills));
    }

    public SkillsDTO updateskill(int id, int skillId, SkillsDTO skillDTO) {
        Skills skills  = skillsRepo.findByIdAndUserId(skillId,id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Skill Not Found"));
        skillsMapper.updateEntity(skills,skillDTO);
        return skillsMapper.toDTO(skillsRepo.save(skills));
    }

    public void deleteSkill(int userId, int skillId) {
        Skills skill = skillsRepo.findById(skillId).orElseThrow(() -> new RuntimeException("Project not found"));
        if(skill.getUser().getId() != userId){
            throw new RuntimeException("No such Project");
        }
        skillsRepo.delete(skill);
    }
}
