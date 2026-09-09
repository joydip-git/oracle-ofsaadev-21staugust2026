package com.oracle.security.authdaodemo.filters;

import com.oracle.security.authdaodemo.services.JwtTokenManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenManager jwtTokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //code
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || authorizationHeader.isBlank())
            throw new SecurityException("authorization header is absent");

        if (!authorizationHeader.contains("Bearer"))
            throw new SecurityException("not a bearer token");

        String tokenValue = authorizationHeader.substring(7);
        if (tokenValue.isEmpty())
            throw new SecurityException("token is absent");

        boolean isValid = jwtTokenManager.verifyToken(tokenValue);


        filterChain.doFilter(request, response);
    }
}
