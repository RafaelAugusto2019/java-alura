package com.estudos.alura.api.controller.authentication;

import com.estudos.alura.api.dto.user.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody UserRequest userRequest){
        var token = new UsernamePasswordAuthenticationToken(
                userRequest.user(),
                userRequest.password());

        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
