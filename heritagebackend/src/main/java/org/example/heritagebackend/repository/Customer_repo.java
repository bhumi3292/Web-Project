package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_repo extends JpaRepository<Customers,Long> {
}
