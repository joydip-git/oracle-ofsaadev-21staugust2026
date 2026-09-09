package com.oracle.security.authdaodemo.controllers;

import com.oracle.security.authdaodemo.dtos.AppUserRequest;
import com.oracle.security.authdaodemo.dtos.AppUserResponse;
import com.oracle.security.authdaodemo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AppUserResponse> register(@RequestBody AppUserRequest user) {
        try {
            return ResponseEntity.created(new URI("/api/auth/register"))
                    .body(authService.saveUser(user));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(500))
                    .build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AppUserRequest user) {
        try {
            return ResponseEntity.ok(authService.validate(user));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(500))
                    .build();
        }
    }

}
