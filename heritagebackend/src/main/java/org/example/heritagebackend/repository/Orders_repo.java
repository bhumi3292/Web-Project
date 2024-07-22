package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orders_repo extends JpaRepository<Orders, Long> {
}
