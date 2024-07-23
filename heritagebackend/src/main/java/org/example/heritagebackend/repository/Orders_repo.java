package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Orders_repo extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomerCustomerId(Long id);
}
