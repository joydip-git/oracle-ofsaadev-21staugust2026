package com.oracle.security.authdaodemo.dtos;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AppUserPrincipal implements UserDetails {

    private AppUserResponse user;

    public AppUserPrincipal(AppUserResponse user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Collections.singleton(authority);
    }

    @Override
    public @Nullable String getPassword() {
       return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return  user.getUsername();
    }
}
