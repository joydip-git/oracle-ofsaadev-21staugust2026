package com.oracle.microservices.apigatewayapp.repository;

import com.oracle.microservices.apigatewayapp.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
}

