package com.oracle.security.authdaodemo.services;

import com.oracle.security.authdaodemo.dtos.AppUserRequest;
import com.oracle.security.authdaodemo.dtos.AppUserResponse;
import com.oracle.security.authdaodemo.entities.AppUser;
import com.oracle.security.authdaodemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AppUserRepository repository;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    public AppUserResponse saveUser(AppUserRequest user) {
        AppUser entity = new AppUser(0L,
                user.getUsername(), user.getPassword(), user.getRole());
        repository.save(entity);
        return new AppUserResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getRole()
        );
    }

    public String validate(AppUserRequest user) {
        Optional<AppUser> found = repository.findByusername(user.getUsername());
        found.orElseThrow(() -> new UsernameNotFoundException("user with " + user.getUsername() + "not found.."));

        return jwtTokenManager.createToken(user);
    }
}
