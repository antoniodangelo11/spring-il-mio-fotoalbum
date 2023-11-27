package org.course.experis.springilmiofotoalbum.controller.api;


import jakarta.validation.Valid;
import org.course.experis.springilmiofotoalbum.model.Contact;
import org.course.experis.springilmiofotoalbum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@CrossOrigin
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @GetMapping
    public List<Contact> index (){
        return contactService.getContactList();
    }

    @PostMapping
    public Contact create(@Valid @RequestBody Contact contact){
        return contactService.createContact(contact);
    }

}
