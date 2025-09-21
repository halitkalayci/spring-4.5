package com.turkcell.intro.web.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtUtil
{
    private String SECRET_KEY = "455293cd723a359b7987cc32f5437ed49d235f4ec484d42c7ddd5390a20ba9d9c52d92a4f638cc96cb4dda5c74916f76e3146b97de3c1d8d18dc8649ac47d051";

    public String generateToken(String username)
    {
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);

        HashMap<String, Object> claims = new HashMap<String, Object>();

        claims.put("username", username);
        claims.put("admin",true);

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String jwt = Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expirationDate)
                .claims(claims)
                .signWith(key)
                .compact();
        return jwt;
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

    private Claims extractAllClaims(String token)
    {
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
