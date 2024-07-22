package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Payments_repo extends JpaRepository<Payments,Long> {
}
