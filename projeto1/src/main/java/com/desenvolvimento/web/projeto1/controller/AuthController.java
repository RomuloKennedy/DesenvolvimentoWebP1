package com.desenvolvimento.web.projeto1.controller;


import com.desenvolvimento.web.projeto1.dto.LoginDTO;
import com.desenvolvimento.web.projeto1.services.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final TokenService service;


    public AuthController(TokenService service) {
        this.service = service;

    }

    @PostMapping("/token")
    public String getToken(Authentication authentication){

        System.out.println("Controller");

        String token = service.generateToken(authentication);
        return token;
    }
}
