package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.Cart;
import org.example.heritagebackend.pojo.Cart_pojo;

import java.util.List;
import java.util.Optional;

public interface cart_service {
    List<Cart> getAllCarts();
    List<Cart> getAllCartsByCustomer(Long customerId);
    Optional<Cart> getCart(Long id);
    Cart addCart(Cart_pojo cartPojo);
    Cart updateCart(Long id, Cart_pojo cartPojo);
    void deleteCart(Long id);
}
