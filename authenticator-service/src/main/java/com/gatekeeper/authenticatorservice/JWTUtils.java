package com.gatekeeper.authenticatorservice;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtils {
    private final String SECRET ="ni2U9EazJB9EAxIiSVBQzdMjtqhnqVl3";
    private final long EXPIRATION_TIME = 1000*60*5;

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .claim("sub", username)
                .claim("iat", new Date())
                .claim("exp", new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }


    public boolean validateToken(String token) {
       try {
           Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
           return true;
       }
       catch (Exception e) {
           return false;
       }
    }
}
