package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.services.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    @Autowired
    private TweetService service;

    @PostMapping
    public void create(@RequestHeader("User") String username, @RequestBody TweetDTO req) {
        service.save(username, req);
    }
}
