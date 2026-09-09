package com.oracle.security.authdaodemo.repository;

import com.oracle.security.authdaodemo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByusername(String username);

    //@Query("SELECT au FROM AppUser WHERE au.username=:username AND au.password=:password")
    //Optional<AppUser> findByusernameAndpassword(String username, String password);
}
