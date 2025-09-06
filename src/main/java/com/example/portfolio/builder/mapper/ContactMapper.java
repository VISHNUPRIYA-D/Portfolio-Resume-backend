package com.example.portfolio.builder.mapper;

import com.example.portfolio.builder.dto.ContactDTO;
import com.example.portfolio.builder.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public  ContactDTO toDTO(Contact contact){
        if(contact != null){
          ContactDTO contactDTO = new ContactDTO();
          contactDTO.setId(contact.getId());
          contactDTO.setEmail(contact.getEmail());
          contactDTO.setPhone(contact.getPhone());
          contactDTO.setAddress(contact.getAddress());
          return contactDTO;
        }else return null;
    }

    public Contact toEntity(ContactDTO contactDTO){
        if(contactDTO != null){
            Contact contact = new Contact();
            contact.setId(contactDTO.getId());
            contact.setEmail(contactDTO.getEmail());
            contact.setPhone(contactDTO.getPhone());
            contact.setAddress(contactDTO.getAddress());
            return contact;
        }else return null;
    }

    public void updateEntity(ContactDTO dto, Contact contact) {
        if (dto.getEmail() != null) contact.setEmail(dto.getEmail());
        if (dto.getPhone() != null) contact.setPhone(dto.getPhone());
        if (dto.getAddress() != null) contact.setAddress(dto.getAddress());
    }
}
