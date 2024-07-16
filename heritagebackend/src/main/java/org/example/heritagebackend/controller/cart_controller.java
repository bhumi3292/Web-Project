package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.cart;
import org.example.heritagebackend.pojo.Cart_pojo;
import org.example.heritagebackend.service.cart_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class cart_controller {

    private final cart_service cartService;

    @PostMapping
    public cart addCart(@RequestBody Cart_pojo cartPojo) {
        return cartService.addCart(cartPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<cart> getCart(@PathVariable Long id) {
        Optional<cart> cartOptional = cartService.getCart(id);
        return cartOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<cart> updateCart(@PathVariable Long id, @RequestBody Cart_pojo cartPojo) {
        cart updatedCart = cartService.updateCart(id, cartPojo);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
