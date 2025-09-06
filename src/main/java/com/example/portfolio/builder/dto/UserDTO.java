package com.example.portfolio.builder.dto;

import com.example.portfolio.builder.model.Experience;

import java.util.List;

public class UserDTO {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public List<EducationDTO> getEducations() {
        return educations;
    }

    public void setEducations(List<EducationDTO> educations) {
        this.educations = educations;
    }

    public List<ExperienceDTO> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ExperienceDTO> experiences) {
        this.experiences = experiences;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public List<SkillsDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsDTO> skills) {
        this.skills = skills;
    }

    public List<SocialMediaDTO> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(List<SocialMediaDTO> socialMedia) {
        this.socialMedia = socialMedia;
    }

    private String username;
    private String name;
    private String title;
    private String about;
    private byte[] image;


    private List<ContactDTO> contacts;
    private List<EducationDTO> educations;
    private List<ExperienceDTO> experiences;
    private List<ProjectDTO> projects;
    private List<SkillsDTO> skills;
    private List<SocialMediaDTO> socialMedia;


}
