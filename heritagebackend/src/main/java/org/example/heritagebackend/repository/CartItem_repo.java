package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.cartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItem_repo extends JpaRepository<cartItem, Long> {
}
