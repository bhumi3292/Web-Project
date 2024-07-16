package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categories_repo extends JpaRepository<categories,Long> {
}
