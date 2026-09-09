package com.oracle.security.authdaodemo.services;

import com.oracle.security.authdaodemo.dtos.AppUserRequest;
import com.oracle.security.authdaodemo.dtos.AppUserResponse;
import com.oracle.security.authdaodemo.entities.AppUser;
import com.oracle.security.authdaodemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AppUserRepository repository;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public AppUserResponse saveUser(AppUserRequest user) {
        AppUser entity = new AppUser(0L,
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                user.getRole());
        repository.save(entity);
        return new AppUserResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getRole()
        );
    }

    public String validate(AppUserRequest user) {

        UsernamePasswordAuthenticationToken unauthorized =
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                );
        Authentication authorized =
                authenticationManager.authenticate(unauthorized);

        if (authorized.isAuthenticated())
            return jwtTokenManager.createToken(user);
        else
            throw new UsernameNotFoundException("user: " + user.getUsername() + " not found");
    }
}
