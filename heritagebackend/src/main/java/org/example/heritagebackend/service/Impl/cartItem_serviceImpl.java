package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.cartItem;
import org.example.heritagebackend.pojo.CartItem_pojo;
import org.example.heritagebackend.repository.CartItem_repo;
import org.example.heritagebackend.service.cartItem_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class cartItem_serviceImpl implements cartItem_service {
    private final CartItem_repo cartItemRepo;

    @Override
    public List<cartItem> getCartItem() {
        return cartItemRepo.findAll();
    }

    @Override
    public Optional<cartItem> getCartItemById(Long id) {
        return cartItemRepo.findById(id);
    }

    @Override
    public cartItem addCartItem(CartItem_pojo cartItemPojo) {
        cartItem newCartItem = new cartItem();
        mapPojoToEntity(newCartItem, cartItemPojo);
        return cartItemRepo.save(newCartItem);
    }

    @Override
    public cartItem updateCartItem(CartItem_pojo cartItemPojo, Long id) {
        Optional<cartItem> cartItemOptional = cartItemRepo.findById(id);
        if (cartItemOptional.isPresent()) {
            cartItem existingCartItem = cartItemOptional.get();
            mapPojoToEntity(existingCartItem, cartItemPojo);
            return cartItemRepo.save(existingCartItem);
        }
        return null;
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepo.deleteById(id);
    }

    private void mapPojoToEntity(cartItem cartItem, CartItem_pojo cartItemPojo) {
        cartItem.setQuantity(cartItemPojo.getQuantity());
        cartItem.setCart(cartItemPojo.getCart());
        cartItem.setProduct(cartItemPojo.getProduct());
    }
}
