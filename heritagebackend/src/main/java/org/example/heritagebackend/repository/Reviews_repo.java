package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reviews_repo extends JpaRepository<reviews,Long> {
}
