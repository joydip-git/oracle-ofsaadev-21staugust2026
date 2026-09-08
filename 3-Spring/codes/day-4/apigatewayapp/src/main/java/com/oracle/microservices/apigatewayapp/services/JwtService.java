package com.oracle.microservices.apigatewayapp.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private String secretKey = "poVTv0qx1VizUJwew5aKiL115kSC3FQt86VQbqX6NLb";
    private SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        JwtBuilder builder = Jwts.builder();
        return builder.claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (60 * 60 * 60 * 24)))
                .and()
                .signWith(key)
                .compact();
    }

    public boolean verifyToken(String token, UserDetails user) {
        String userName = extractUserName(token);
        Claims claims = extractClaims(token);
        Date expiration = claims.getExpiration();
        return (userName.equals(user.getUsername()) && !expiration.before(new Date()));
    }

    private Claims extractClaims(String token) {
        JwtParserBuilder parserBuilder = Jwts.parser().verifyWith(key);
        JwtParser parser = parserBuilder.build();
        return parser.parseSignedClaims(token).getPayload();
    }

    public String extractUserName(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }
}
