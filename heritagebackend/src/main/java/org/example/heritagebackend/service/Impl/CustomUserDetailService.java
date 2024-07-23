package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.repository.Customer_repo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final Customer_repo customerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers customers=customerRepo.findByEmail(username).orElse(null);
        if(customers!=null){
            return  customers;

        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}

