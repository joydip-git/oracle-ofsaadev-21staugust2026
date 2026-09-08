package com.oracle.microservices.apigatewayapp.services;

import com.oracle.microservices.apigatewayapp.dtos.AppUserPrincipal;
import com.oracle.microservices.apigatewayapp.dtos.AppUserResponse;
import com.oracle.microservices.apigatewayapp.entities.AppUser;
import com.oracle.microservices.apigatewayapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> found = repository.findByUsername(username);
        found.orElseThrow(() -> new UsernameNotFoundException("user not found"));

        AppUser user = found.get();
        return new AppUserPrincipal(new AppUserResponse(user.getId(), user.getUsername(), user.getPassword(), user.getRole()));

//        AppUser found = repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("usrer not found"));
//        UserDetails user = User
//                .builder()
//                .username(found.getUsername())
//                .password(found.getPassword())
//				  .roles(found.getRole())
//                .build();
//
//        return user;
    }
}
