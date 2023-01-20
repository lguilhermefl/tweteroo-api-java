package com.tweteroo.tweteroo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    
}
