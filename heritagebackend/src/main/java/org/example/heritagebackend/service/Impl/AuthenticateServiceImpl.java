package org.example.heritagebackend.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.configure.JwtService;
import org.example.heritagebackend.pojo.AuthPojo;
import org.example.heritagebackend.repository.Customer_repo;
import org.example.heritagebackend.service.AuthenticateService;
import org.example.heritagebackend.util.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtUtils;
    private final Customer_repo customerRepo;
    @Override
    public AuthResponse authenticate(AuthPojo authenticateRequest) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(), authenticateRequest.getPassword())
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(userDetails);
        Customers customers=customerRepo.findByEmail(authenticateRequest.getEmail()).orElse(null);
        if(customers!=null){
            return  AuthResponse.builder()
                    .token(jwtToken)
                    .userId(customers.getCustomerId())

                    .build();

        }
        throw new EntityNotFoundException("User not found");
    }
}
