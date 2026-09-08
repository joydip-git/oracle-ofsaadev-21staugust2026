package com.oracle.security.authdaodemo.repository;

import com.oracle.security.authdaodemo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByusername(String username);
}
