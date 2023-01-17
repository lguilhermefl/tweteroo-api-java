package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.repositories.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    @Autowired
    private TweetRepository repository;

    @PostMapping
    public void create(@RequestBody TweetDTO req) {
        repository.save(new Tweet(req));
    }
}
