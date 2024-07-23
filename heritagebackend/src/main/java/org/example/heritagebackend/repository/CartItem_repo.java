package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItem_repo extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartCustomerCustomerId(Long cartId);
}
