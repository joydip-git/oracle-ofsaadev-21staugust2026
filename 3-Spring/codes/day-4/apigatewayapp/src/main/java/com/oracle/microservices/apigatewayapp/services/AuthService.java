package com.oracle.microservices.apigatewayapp.services;

import com.oracle.microservices.apigatewayapp.dtos.AppUserRequest;
import com.oracle.microservices.apigatewayapp.dtos.AppUserResponse;
import com.oracle.microservices.apigatewayapp.entities.AppUser;
import com.oracle.microservices.apigatewayapp.repository.AppUserRepository;
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
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AppUserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    // private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    private AppUser toEntity(AppUserRequest user) {
        AppUser entity = new AppUser();
        entity.setUsername(user.username());
        entity.setPassword(encoder.encode(user.password()));
        return entity;
    }

    private AppUserResponse toResponse(AppUser user) {
        return new AppUserResponse(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
    }

    public AppUserResponse createUser(AppUserRequest request) {
        AppUser entity = toEntity(request);
        AppUser added = repository.save(entity);
        return toResponse(added);
    }

    public String verify(AppUserRequest userRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userRequest.username(),
                userRequest.password());
        Authentication authentication = authenticationManager.authenticate(authToken);
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userRequest.username());
        } else
            throw new UsernameNotFoundException("user with " + userRequest.username() + " not found");
    }
}
