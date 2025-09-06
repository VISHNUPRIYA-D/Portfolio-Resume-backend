package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.SocialMediaDTO;
import com.example.portfolio.builder.model.Socialmedia;
import org.springframework.stereotype.Component;

@Component
public class SocialMediaMapper {
    public SocialMediaDTO toDTO(Socialmedia socialmedia){
        SocialMediaDTO socialMediaDTO = new SocialMediaDTO();
        if(socialmedia!=null){
            socialMediaDTO.setId(socialmedia.getId());
            socialMediaDTO.setPlatform(socialmedia.getPlatform());
            socialMediaDTO.setUrl(socialmedia.getUrl());
            return socialMediaDTO;
        }
       else return null;
    }

    public static Socialmedia toEntity(SocialMediaDTO socialMediaDTO){
        if(socialMediaDTO!=null){
            Socialmedia socialmedia = new Socialmedia();
            socialmedia.setId(socialMediaDTO.getId());
            socialmedia.setPlatform(socialMediaDTO.getPlatform());
            socialmedia.setUrl(socialMediaDTO.getUrl());
            return socialmedia;
        }
        else return null;
    }

    public void updateEntity(Socialmedia socialmedia,SocialMediaDTO socialMediaDTO){
        if(socialMediaDTO.getPlatform()!=null) socialmedia.setPlatform(socialMediaDTO.getPlatform());
        if(socialMediaDTO.getUrl()!=null)socialmedia.setUrl(socialMediaDTO.getUrl());
    }
}
