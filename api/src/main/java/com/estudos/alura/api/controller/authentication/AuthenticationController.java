package com.estudos.alura.api.controller.authentication;

import com.estudos.alura.api.dto.user.UserRequest;
import com.estudos.alura.api.repository.user.UserJPA;
import com.estudos.alura.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody UserRequest userRequest){
        var token = new UsernamePasswordAuthenticationToken(
                userRequest.user(),
                userRequest.password());

        var authentication = authenticationManager.authenticate(token);

        var tokenJWT = tokenService.buildJWTToken((UserJPA) authentication.getPrincipal());

        return ResponseEntity.ok(new tokenJWTResponse(tokenJWT));
    }
}
