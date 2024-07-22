package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItem_repo extends JpaRepository<CartItem, Long> {
}
