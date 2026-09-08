package com.oracle.microservices.apigatewayapp.dtos;

public record AppUserResponse(Long id, String username, String password, String role) {
}