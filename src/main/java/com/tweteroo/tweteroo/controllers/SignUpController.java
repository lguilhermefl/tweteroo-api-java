package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.UserDTO;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sign-up")
public class SignUpController {
    
    @Autowired
    private UserRepository repository;

    @PostMapping
    public void create(@RequestBody UserDTO req) {
        repository.save(new User(req));
    }
}
