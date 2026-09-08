package com.oracle.microservices.apigatewayapp;


import com.oracle.microservices.apigatewayapp.dtos.AppUserRequest;
import com.oracle.microservices.apigatewayapp.dtos.AppUserResponse;
import com.oracle.microservices.apigatewayapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AppUserResponse register(@RequestBody AppUserRequest user) {
        return authService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUserRequest user) {
        return authService.verify(user);
    }
}
