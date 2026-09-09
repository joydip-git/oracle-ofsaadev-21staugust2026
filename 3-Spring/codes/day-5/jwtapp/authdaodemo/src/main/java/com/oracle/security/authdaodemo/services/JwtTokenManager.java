package com.oracle.security.authdaodemo.services;

import com.oracle.security.authdaodemo.dtos.AppUserRequest;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenManager {

    private final String private_key = "mysecretkeymysecretkeymysecretkeymysecretkeymysecretkey";
    private final SecretKey secretKey = Keys.hmacShaKeyFor(private_key.getBytes());

    public String createToken(AppUserRequest user) {
        JwtBuilder jwtBuilder = Jwts.builder();
        Map<String, Object> claims = new HashMap<>();
        return jwtBuilder
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (60 * 60 * 60 * 24)))
                .and()
                .signWith(secretKey)
                .compact();
    }

    public boolean verifyToken(String token, String username) {
        Claims payload = extractClaims(token);
        return (!payload.getExpiration().before(new Date())
                &&
                payload.getSubject().equals(username));
    }

    public Claims extractClaims(String token) {
        JwtParserBuilder parserBuilder = Jwts.parser();
        JwtParser jwtParser = parserBuilder.verifyWith(secretKey).build();
        return jwtParser.parseSignedClaims(token).getPayload();
    }
}
