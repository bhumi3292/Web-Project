package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.cart;
import org.example.heritagebackend.pojo.Cart_pojo;

import java.util.List;
import java.util.Optional;

public interface cart_service {
    List<cart> getAllCarts();
    Optional<cart> getCart(Long id);
    cart addCart(Cart_pojo cartPojo);
    cart updateCart(Long id, Cart_pojo cartPojo);
    void deleteCart(Long id);
}
