package org.example.heritagebackend.service;


import org.example.heritagebackend.pojo.AuthPojo;
import org.example.heritagebackend.util.AuthResponse;

public interface AuthenticateService {
    AuthResponse authenticate(AuthPojo authenticateRequest);
//    Credentials createUser(String email, String password, UserType userType);
}
