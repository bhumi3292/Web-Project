package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.ValueExp;
import java.util.List;

public interface cart_repo extends JpaRepository<Cart, Long> {
    List<Cart> findByCustomerCustomerId(Long customerId);


}
