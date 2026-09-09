package com.oracle.security.authdaodemo.services;

import com.oracle.security.authdaodemo.dtos.AppUserPrincipal;
import com.oracle.security.authdaodemo.dtos.AppUserResponse;
import com.oracle.security.authdaodemo.entities.AppUser;
import com.oracle.security.authdaodemo.repository.AppUserRepository;
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
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<AppUser> found = repository.findByusername(username);
        found.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));

        AppUser user = found.get();

        AppUserResponse userResponse = new AppUserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
        return new AppUserPrincipal(userResponse);
//        User.UserBuilder userBuilder = User.builder();
//        userBuilder.username(user.getUsername());
//        userBuilder.password(user.getPassword());
//        userBuilder.roles(user.getRole());
//        return userBuilder.build();
    }
}
