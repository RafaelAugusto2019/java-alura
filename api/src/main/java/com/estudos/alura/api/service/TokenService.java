package com.estudos.alura.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.estudos.alura.api.repository.user.UserJPA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String buildJWTToken(UserJPA userJPA){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("api_voll_med")
                    .withClaim("username", userJPA.getUsername())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
           throw new RuntimeException("Error building JWT token");
        }

    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusMinutes(20).toInstant(
                ZoneId.systemDefault()
                        .getRules().
                        getOffset(Instant.now())
        );
    }

}
