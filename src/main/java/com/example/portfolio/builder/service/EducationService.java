package com.example.portfolio.builder.service;

import com.example.portfolio.builder.dto.EducationDTO;
import com.example.portfolio.builder.mapper.EducationMapper;
import com.example.portfolio.builder.model.Education;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.EducationRepo;
import com.example.portfolio.builder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private final  EducationRepo educationRepo;
    @Autowired
    private final EducationMapper educationMapper;

    private final UserRepo userRepo;

    public EducationService(EducationRepo educationRepo, EducationMapper educationMapper, UserRepo userRepo) {
        this.educationRepo = educationRepo;
        this.educationMapper = educationMapper;
        this.userRepo = userRepo;
    }


    public EducationDTO addEducation(int id, EducationDTO educationDTO) {
        User user = userRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));

            Education education = educationMapper.toEntity(educationDTO);
            education.setUser(user);
            return educationMapper.toDTO(educationRepo.save(education));
    }


    public List<EducationDTO> getEducationById(int id) {
            return educationRepo.findByUserId(id).stream().map(educationMapper::toDTO).collect(Collectors.toList());

    }

    public EducationDTO updateEducation(int id, EducationDTO educationDTO, int educationId) {
        Education education = educationRepo.findByIdAndUserId(educationId, id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Education Not Found"));
        educationMapper.updateEntity(education, educationDTO);
        return educationMapper.toDTO(educationRepo.save(education));

    }

    public void deleteEducation(int userId, int educationId) {
        Education education = educationRepo.findById(educationId)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        if(education.getUser().getId() != userId){
            throw new RuntimeException("No such education");
        }
            educationRepo.delete(education);

    }
}




