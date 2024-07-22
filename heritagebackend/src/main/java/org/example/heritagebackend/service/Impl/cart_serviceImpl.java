package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Cart;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.pojo.Cart_pojo;
import org.example.heritagebackend.repository.Customer_repo;
import org.example.heritagebackend.repository.cart_repo;
import org.example.heritagebackend.service.cart_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class cart_serviceImpl implements cart_service {
    private final cart_repo cartRepo;
    private final Customer_repo customerRepo;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    @Override
    public Optional<Cart> getCart(Long id) {
        return cartRepo.findById(id);
    }

    @Override
    public Cart addCart(Cart_pojo cartPojo) {
        Cart newCart = new Cart();
        mapPojoToEntity(newCart, cartPojo);
        return cartRepo.save(newCart);
    }

    @Override
    public Cart updateCart(Long id, Cart_pojo cartPojo) {
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isPresent()) {
            Cart existingCart = cartOptional.get();
            mapPojoToEntity(existingCart, cartPojo);
            return cartRepo.save(existingCart);
        }
        return null;
    }

    @Override
    public void deleteCart(Long id) {
        cartRepo.deleteById(id);
    }

    private void mapPojoToEntity(Cart cart, Cart_pojo cartPojo) {
        Optional<Customers> customersOptional=customerRepo.findById(cartPojo.getCustomerId());
        if (customersOptional.isPresent()) {
            Customers customers = customersOptional.get();
            cart.setCustomer(customers);
        }

    }
}
