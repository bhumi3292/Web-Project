package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.cart;
import org.example.heritagebackend.pojo.Cart_pojo;
import org.example.heritagebackend.repository.cart_repo;
import org.example.heritagebackend.service.cart_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class cart_serviceImpl implements cart_service {
    private final cart_repo cartRepo;

    @Override
    public List<cart> getAllCarts() {
        return cartRepo.findAll();
    }

    @Override
    public Optional<cart> getCart(Long id) {
        return cartRepo.findById(id);
    }

    @Override
    public cart addCart(Cart_pojo cartPojo) {
        cart newCart = new cart();
        mapPojoToEntity(newCart, cartPojo);
        return cartRepo.save(newCart);
    }

    @Override
    public cart updateCart(Long id, Cart_pojo cartPojo) {
        Optional<cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isPresent()) {
            cart existingCart = cartOptional.get();
            mapPojoToEntity(existingCart, cartPojo);
            return cartRepo.save(existingCart);
        }
        return null;
    }

    @Override
    public void deleteCart(Long id) {
        cartRepo.deleteById(id);
    }

    private void mapPojoToEntity(cart cart, Cart_pojo cartPojo) {
        cart.setCustomer(cartPojo.getCustomer());
    }
}
