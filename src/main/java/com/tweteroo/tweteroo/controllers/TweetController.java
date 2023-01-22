package com.tweteroo.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.services.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    
    @Autowired
    private TweetService service;

    @PostMapping
    public void create(@RequestHeader("User") String username, @RequestBody TweetDTO req) {
        service.save(username, req);
    }

    @GetMapping
    public List<Tweet> getLastFiveTweets(@RequestParam String page) {
        int pageNumber = Integer.parseInt(page);
        Pageable sortedByIdDesc = PageRequest.of(pageNumber, 5, Sort.by("id").descending());
        return service.getTweets(sortedByIdDesc);
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsByUser(@PathVariable String username) {
        return service.getTweetsByUser(username);
    }
}
