package com.green_alert.green_alert_backend.Jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private int EXPIRATION;

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    private Key getKey() {
        byte[] kyeBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(kyeBytes);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails user) {
        return Jwts
            .builder()
            .claims(extraClaims)
            .subject(user.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(getKey())
            .compact()
        ;
    }
}
