package org.course.experis.springilmiofotoalbum.controller;

import org.course.experis.springilmiofotoalbum.model.User;
import org.course.experis.springilmiofotoalbum.repository.UserRepository;
import org.course.experis.springilmiofotoalbum.security.DatabaseUserDetails;
import org.course.experis.springilmiofotoalbum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public String index (Authentication authentication, Model model){
        DatabaseUserDetails principal = (DatabaseUserDetails) authentication.getPrincipal();
        User loggedUser = userRepository.findById(principal.getId()).get();
        model.addAttribute(loggedUser.getFirstName());
        model.addAttribute(loggedUser.getLastName());

        model.addAttribute("userList", userService.getUserList());

        return "/users/list";
    }
}
