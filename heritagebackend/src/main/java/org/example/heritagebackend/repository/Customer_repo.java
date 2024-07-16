package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_repo extends JpaRepository<customers,Long> {
}
