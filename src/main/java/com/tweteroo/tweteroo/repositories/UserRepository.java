package com.tweteroo.tweteroo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
