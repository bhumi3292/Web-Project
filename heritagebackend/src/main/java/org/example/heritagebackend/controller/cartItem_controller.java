package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.CartItem;
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
    public CartItem addCartItem(@RequestBody CartItem_pojo cartItemPojo) {
        return cartItemService.addCartItem(cartItemPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getCartItem();
    }
@GetMapping("/cart/{cartId}")
    public List<CartItem> getAllCartItemsbyCartId(@PathVariable Long cartId) {
        return cartItemService.getCartItembycartId(cartId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        Optional<CartItem> cartItemOptional = cartItemService.getCartItemById(id);
        return cartItemOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem_pojo cartItemPojo) {
        CartItem updatedCartItem = cartItemService.updateCartItem(cartItemPojo, id);
        if (updatedCartItem != null) {
            return ResponseEntity.ok(updatedCartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
