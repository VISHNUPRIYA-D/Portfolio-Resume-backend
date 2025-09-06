package com.example.portfolio.builder.service;

import com.example.portfolio.builder.dto.ContactDTO;
import com.example.portfolio.builder.mapper.ContactMapper;
import com.example.portfolio.builder.model.Contact;
import com.example.portfolio.builder.model.User;
import com.example.portfolio.builder.repository.ContactRepo;
import com.example.portfolio.builder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private final  ContactRepo contactRepo;
    @Autowired
    private final ContactMapper contactMapper;

    private final UserRepo userRepo;

    public ContactService(ContactRepo contactRepo, ContactMapper contactMapper, UserRepo userRepo) {
        this.contactRepo = contactRepo;
        this.contactMapper = contactMapper;
        this.userRepo = userRepo;
    }


    public ContactDTO addContact(Integer userId, ContactDTO contactDTO) {
        User user = userRepo.findById(userId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
       Contact contact = contactMapper.toEntity(contactDTO);
       contact.setUser(user);
       return contactMapper.toDTO(contactRepo.save(contact));
    }

    public ContactDTO updateContact(Integer userId, Integer contactId, ContactDTO contactDTO) {

        Contact contact = contactRepo.findByIdAndUserId(contactId, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        contactMapper.updateEntity(contactDTO, contact);

        return contactMapper.toDTO(contactRepo.save(contact));
    }

    public List<ContactDTO> getContactsByUser(Integer userId) {
        return contactRepo.findByUserId(userId).stream().map(contactMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteContact(Integer contactId, Integer userId) {
        Contact contact = contactRepo.findById(contactId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        if(contact.getUser().getId() != userId) {
            throw new RuntimeException("This contact does not belong to the user");
        }
        contactRepo.delete(contact);
    }
}
