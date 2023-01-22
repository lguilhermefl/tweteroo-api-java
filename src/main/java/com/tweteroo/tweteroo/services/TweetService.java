package com.tweteroo.tweteroo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.AppUser;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.repositories.TweetRepository;
import com.tweteroo.tweteroo.repositories.UserRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void save(String username, TweetDTO dto) {
        Optional<AppUser> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
            repository.save(new Tweet(dto, username, user.get().getAvatar()));
        }
    }

    public List<Tweet> getTweets(Pageable page) {
        return repository.findAllByOrderByIdDesc(page);
    }
}
