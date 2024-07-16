package org.example.heritagebackend.service ;

import org.example.heritagebackend.Entity.cartItem;
import org.example.heritagebackend.pojo.CartItem_pojo;

import java.util.List;
import java.util.Optional;

public interface cartItem_service {

    List<cartItem> getCartItem();
    Optional<cartItem> getCartItemById(Long Id);
    cartItem addCartItem(CartItem_pojo CartItemPojo);
    cartItem updateCartItem(CartItem_pojo CartItemPojo, Long id);
    void deleteCartItem(Long id);
}
