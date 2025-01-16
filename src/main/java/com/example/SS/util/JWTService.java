package com.example.SS.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    public String secretKey ;

    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk = keygen.generateKey();
        secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
    }


    public String generateToken(String username) {

        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*60*30))
                .and()
                .signWith(getkey())
                .compact();


//        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0aGFydW5zciIsIm5hbWUiOiJKb2huIERvZSIsImlhdCI6MTcyOTIxOTA5OSwiZXhwIjoxNzQ5MjE5MDk5fQ.wLWN-kXUy5CD3LFQw27Zw4rZnHkNovgsEsAzipzrY7k";
    }
    public Key getkey(){
        byte[] ans = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(ans);
    }
}
