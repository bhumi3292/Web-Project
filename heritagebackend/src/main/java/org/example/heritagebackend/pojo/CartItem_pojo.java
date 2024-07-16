package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.products;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem_pojo {
    private Long cartItemId;
    private Integer quantity;
    private org.example.heritagebackend.Entity.cart cart;
    private products product;
}
