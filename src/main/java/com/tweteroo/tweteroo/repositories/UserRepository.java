package com.tweteroo.tweteroo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    
    Optional<AppUser> findByUsername(String username);
}
