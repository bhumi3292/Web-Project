package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.pojo.AuthPojo;
import org.example.heritagebackend.service.AuthenticateService;
import org.example.heritagebackend.util.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticateService authenticateService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthPojo authRequest) {
        AuthResponse authResponse = authenticateService.authenticate(authRequest);
        System.out.println(authResponse);
        if (authResponse != null) {
            return  ResponseEntity.ok(authResponse);
        } else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
