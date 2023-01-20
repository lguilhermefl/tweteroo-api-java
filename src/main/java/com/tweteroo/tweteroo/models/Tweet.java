package com.tweteroo.tweteroo.models;

import com.tweteroo.tweteroo.dtos.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tweet {
    
    public Tweet(TweetDTO data) {
        this.username = data.username();
        this.text = data.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 50, nullable = false)
    String username;

    @Column(length = 200, nullable = false)
    String avatar;

    @Column(length = 140, nullable = false)
    String text;
}
