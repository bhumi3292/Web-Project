package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Customers implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_seq", allocationSize = 1)
    private Long customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String country;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("customer"));
    }

    @Override
    public String getUsername() {
        return email; // Assuming email is the username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement your logic for account expiration
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your logic for account locking
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your logic for credentials expiration
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic for account enabled/disabled
    }


    @PrePersist
    @PreUpdate
    private void hashPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(this.password);
    }


}



