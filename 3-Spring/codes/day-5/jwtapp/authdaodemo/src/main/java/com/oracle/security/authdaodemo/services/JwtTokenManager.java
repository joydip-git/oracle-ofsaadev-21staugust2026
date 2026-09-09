package com.oracle.security.authdaodemo.services;

import com.oracle.security.authdaodemo.dtos.AppUserRequest;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenManager {

    public String createToken(AppUserRequest user) {
        return null;
    }

    public boolean verifyToken(String token) {
        return false;
    }
}
