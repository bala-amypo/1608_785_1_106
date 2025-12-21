package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwTokenProvider {

    private final String secretKey;
    private final long expirationMillis;

    public JwtTokenProvider(String secretKey, long expirationMillis) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Jws<Claims> validateToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    }

    public String extractEmail(String token) {
        return validateToken(token).getBody().get("email", String.class);
    }

    public Long extractUserId(String token) {
        return validateToken(token).getBody().get("userId", Long.class);
    }

    public String extractRole(String token) {
        return validateToken(token).getBody().get("role", String.class);
    }
}
