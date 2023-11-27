package org.course.experis.springilmiofotoalbum.controller;

import org.course.experis.springilmiofotoalbum.exceptions.ContactNotFoundException;
import org.course.experis.springilmiofotoalbum.model.Contact;
import org.course.experis.springilmiofotoalbum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String index (Authentication authentication, Model model){
        model.addAttribute("contactList", contactService.getContactList());
        return "/contacts/list";
    }

    @GetMapping("/show/{id}")
    public String show (@PathVariable Integer id, Model model){
        try{
            Contact contact = contactService.getContactById(id);
            model.addAttribute("contact", contact);
            return "contacts/show";
        }catch (ContactNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try{
            Contact contactToDelete = contactService.getContactById(id);
            contactService.deleteContact(id);
            redirectAttributes.addFlashAttribute(
                    "contact",
                    "Contact deleted!"
            );
            return "redirect:/contacts";
        }catch (ContactNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
