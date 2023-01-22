package com.tweteroo.tweteroo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Page<Tweet> findAllSortedByIdDesc(Pageable pageable);
}
