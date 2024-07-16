package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.cartItem;
import org.example.heritagebackend.pojo.CartItem_pojo;
import org.example.heritagebackend.service.cartItem_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart-items")
@RequiredArgsConstructor
public class cartItem_controller {


    private final cartItem_service cartItemService;

    @PostMapping
    public cartItem addCartItem(@RequestBody CartItem_pojo cartItemPojo) {
        return cartItemService.addCartItem(cartItemPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<cartItem> getAllCartItems() {
        return cartItemService.getCartItem();
    }

    @GetMapping("/{id}")
    public ResponseEntity<cartItem> getCartItemById(@PathVariable Long id) {
        Optional<cartItem> cartItemOptional = cartItemService.getCartItemById(id);
        return cartItemOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<cartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem_pojo cartItemPojo) {
        cartItem updatedCartItem = cartItemService.updateCartItem(cartItemPojo, id);
        if (updatedCartItem != null) {
            return ResponseEntity.ok(updatedCartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
