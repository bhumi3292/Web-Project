package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.Cart;
import org.example.heritagebackend.Entity.Products;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem_pojo {
    private Long cartItemId;
    private Integer quantity;
    private Long cartId;
    private Long productId;
}
