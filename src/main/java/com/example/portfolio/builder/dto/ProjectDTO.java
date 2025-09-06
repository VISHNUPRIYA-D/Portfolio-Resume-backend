package com.example.portfolio.builder.dto;

public class ProjectDTO {
    private int id;


    private String Title;
    private String Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTech() {
        return Tech;
    }

    public void setTech(String tech) {
        Tech = tech;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    private  String Tech;
    private String Link;
}
