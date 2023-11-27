package org.course.experis.springilmiofotoalbum.service;

import org.course.experis.springilmiofotoalbum.model.User;
import org.course.experis.springilmiofotoalbum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }
}