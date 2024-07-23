package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Cart;
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
    public Cart addCart(@RequestBody Cart_pojo cartPojo) {
        return cartService.addCart(cartPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Optional<Cart> cartOptional = cartService.getCart(id);
        return cartOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Cart>> getCartbyCustomer(@PathVariable Long customerId) {
        List<Cart> cartOptional = cartService.getAllCartsByCustomer(customerId);
        return ResponseEntity.ok(cartOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart_pojo cartPojo) {
        Cart updatedCart = cartService.updateCart(id, cartPojo);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
