package org.example.heritagebackend.service ;

import org.example.heritagebackend.Entity.CartItem;
import org.example.heritagebackend.pojo.CartItem_pojo;

import java.util.List;
import java.util.Optional;

public interface cartItem_service {

    List<CartItem> getCartItem();
    Optional<CartItem> getCartItemById(Long Id);
    CartItem addCartItem(CartItem_pojo CartItemPojo);
    CartItem updateCartItem(CartItem_pojo CartItemPojo, Long id);
    void deleteCartItem(Long id);
}
