package com.oracle.microservices.apigatewayapp.filters;

import com.oracle.microservices.apigatewayapp.services.AppUserDetailsService;
import com.oracle.microservices.apigatewayapp.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = null;
        String username = null;
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            token = header.substring(7);
            username = jwtService.extractUserName(token);
        }

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (username != null && authentication == null) {
            UserDetails userDetails = applicationContext.getBean(AppUserDetailsService.class).loadUserByUsername(username);
            boolean isValid = jwtService.verifyToken(token, userDetails);
            if (isValid) {
                UsernamePasswordAuthenticationToken authenticated = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                WebAuthenticationDetailsSource builder = new WebAuthenticationDetailsSource();
                WebAuthenticationDetails details = builder.buildDetails(request);
                authenticated.setDetails(details);
                securityContext.setAuthentication(authenticated);
            }
        }

        filterChain.doFilter(request, response);
    }
}
