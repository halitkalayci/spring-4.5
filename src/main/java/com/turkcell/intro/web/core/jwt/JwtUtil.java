package com.turkcell.intro.web.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class JwtUtil
{
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(String username, List<String> roles)
    {
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);

        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("roles", roles);

        return Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expirationDate)
                .claims(claims)
                .signWith(getSecretKey())
                .compact();
    }

    public Boolean validateToken(String token)
    {
        try
        {
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public String extractUsername(String token)
    {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public List<String> extractRoles(String token)
    {
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts
                .parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
