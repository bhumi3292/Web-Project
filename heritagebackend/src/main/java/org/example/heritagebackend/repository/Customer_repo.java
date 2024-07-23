package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Customer_repo extends JpaRepository<Customers,Long> {
    Optional<Customers> findByEmail(String email);
}
