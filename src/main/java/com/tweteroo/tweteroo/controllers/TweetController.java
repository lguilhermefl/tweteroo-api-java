package com.tweteroo.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.repositories.TweetRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {
    
    @Autowired
    private TweetRepository repository;

    @GetMapping
    public List<Tweet> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody TweetDTO req) {
        repository.save(new Tweet(req));
    }
}
