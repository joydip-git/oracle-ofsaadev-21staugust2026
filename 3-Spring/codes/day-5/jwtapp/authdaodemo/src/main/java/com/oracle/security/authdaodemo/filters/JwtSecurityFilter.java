package com.oracle.security.authdaodemo.filters;

import com.oracle.security.authdaodemo.services.AppUserDetailsService;
import com.oracle.security.authdaodemo.services.JwtTokenManager;
import io.jsonwebtoken.Claims;
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
public class JwtSecurityFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenManager jwtTokenManager;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().startsWith("/api/auth/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

//        if (authorizationHeader == null || authorizationHeader.isBlank())
//            throw new SecurityException("authorization header is absent");
//
//        if (!authorizationHeader.startsWith("Bearer"))
//            throw new SecurityException("not a bearer token");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            String tokenValue = authorizationHeader.substring(7);
            if (!tokenValue.isEmpty()) {

                SecurityContext securityContext = SecurityContextHolder.getContext();
                Authentication authentication = securityContext.getAuthentication();

                Claims payload = jwtTokenManager.extractClaims(tokenValue);
                String username = payload.getSubject();


                if (authentication == null && username != null) {
                    var service = applicationContext.getBean(AppUserDetailsService.class);
                    UserDetails user = service.loadUserByUsername(username);
                    boolean isValid = jwtTokenManager.verifyToken(tokenValue, user.getUsername());
                    if (isValid) {
                        UsernamePasswordAuthenticationToken authorized =
                                new UsernamePasswordAuthenticationToken(
                                        user, null, user.getAuthorities());

                        WebAuthenticationDetailsSource source =
                                new WebAuthenticationDetailsSource();
                        WebAuthenticationDetails details = source.buildDetails(request);
                        authorized.setDetails(details);
                        securityContext.setAuthentication(authorized);
                    }
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
