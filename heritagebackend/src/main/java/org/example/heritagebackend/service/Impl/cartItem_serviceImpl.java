package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Cart;
import org.example.heritagebackend.Entity.CartItem;
import org.example.heritagebackend.Entity.Products;
import org.example.heritagebackend.pojo.CartItem_pojo;
import org.example.heritagebackend.repository.CartItem_repo;
import org.example.heritagebackend.repository.Products_repo;
import org.example.heritagebackend.repository.cart_repo;
import org.example.heritagebackend.service.cartItem_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class cartItem_serviceImpl implements cartItem_service {
    private final CartItem_repo cartItemRepo;
    private final Products_repo productsRepo;
    private final cart_repo cartRepo;

    @Override
    public List<CartItem> getCartItem() {
        return cartItemRepo.findAll();
    }

    @Override
    public Optional<CartItem> getCartItemById(Long id) {
        return cartItemRepo.findById(id);
    }

    @Override
    public CartItem addCartItem(CartItem_pojo cartItemPojo) {
        CartItem newCartItem = new CartItem();
        mapPojoToEntity(newCartItem, cartItemPojo);
        return cartItemRepo.save(newCartItem);
    }

    @Override
    public CartItem updateCartItem(CartItem_pojo cartItemPojo, Long id) {
        Optional<CartItem> cartItemOptional = cartItemRepo.findById(id);
        if (cartItemOptional.isPresent()) {
            CartItem existingCartItem = cartItemOptional.get();
            mapPojoToEntity(existingCartItem, cartItemPojo);
            return cartItemRepo.save(existingCartItem);
        }
        return null;
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepo.deleteById(id);
    }

    private void mapPojoToEntity(CartItem cartItem, CartItem_pojo cartItemPojo) {
        cartItem.setQuantity(cartItemPojo.getQuantity());

        Optional<Products> productsOptional=productsRepo.findById(cartItemPojo.getProductId());
        if (productsOptional.isPresent()) {
            Products products = productsOptional.get();
            cartItem.setProduct(products);
        }
        Optional<Cart> cartOptional=cartRepo.findById(cartItemPojo.getCartId());
        if (productsOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cartItem.setCart(cart);
        }

    }
}
