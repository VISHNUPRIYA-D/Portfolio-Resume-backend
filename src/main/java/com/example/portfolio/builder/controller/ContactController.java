package com.example.portfolio.builder.controller;

import com.example.portfolio.builder.dto.ContactDTO;
import com.example.portfolio.builder.model.Contact;
import com.example.portfolio.builder.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/contacts")
public class ContactController {

    @Autowired
    private  ContactService service;



    @PostMapping("/{userId}")
    public ContactDTO addContact(@PathVariable Integer userId, @RequestBody ContactDTO contactDTO) {
        return service.addContact(userId, contactDTO);
    }

    @PutMapping("/{userId}/{contactId}")
    public ContactDTO updateContact(@PathVariable Integer userId,
                                 @PathVariable Integer contactId,
                                 @RequestBody ContactDTO contactDTO) {
        return service.updateContact(userId, contactId, contactDTO);
    }

    @GetMapping("/{userId}")
    public List<ContactDTO> getContactsByUser(@PathVariable Integer userId) {
        return service.getContactsByUser(userId);
    }

    @DeleteMapping("/{userId}/{contactId}")
    public void deleteContact(@PathVariable Integer contactId,@PathVariable Integer userId) {
        service.deleteContact(contactId,userId);
    }
}
