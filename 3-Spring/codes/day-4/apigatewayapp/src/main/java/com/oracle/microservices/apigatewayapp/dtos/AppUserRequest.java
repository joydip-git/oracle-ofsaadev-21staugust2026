package com.oracle.microservices.apigatewayapp.dtos;

public record AppUserRequest(String username, String password, String role) {}
